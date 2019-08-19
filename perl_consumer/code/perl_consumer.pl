#!/usr/local/bin/perl

use strict;
use warnings;
use v5.18;
use lib "/code";

use Scalar::Util qw(
    blessed
);
use Try::Tiny;

use Avro::Schema;
use Kafka qw(
    $DEFAULT_MAX_BYTES
    $DEFAULT_MAX_NUMBER_OF_OFFSETS
    $RECEIVE_EARLIEST_OFFSET
);
use Kafka::Connection;
use Kafka::Consumer;

use Erik;

$ENV{PERL_KAFKA_DEBUG} = 1;

# http://localhost:8081/schemas/ids/1

my $topic_name = 'config_user_rules';

my ( $connection, $consumer );
try {

    #-- Connection
    $connection = Kafka::Connection->new(
        # host => 'localhost'
        broker_list => [ 'localhost:9092' ],
        timeout     => 100,
    );

    # Erik::dump(metadata => $connection->get_metadata);

    #-- Consumer
    $consumer = Kafka::Consumer->new( Connection  => $connection );

    # Get a valid offset before the given time
    my $offset = $consumer->offset_earliest(
        $topic_name,               # topic
        0,                              # partition
    );

    if ( defined $offset ) {
        say "Received offset: $offset";
    } else {
        warn "Error: Offsets are not received\n";
    }

    Erik::log("Max Bytes: $DEFAULT_MAX_BYTES");
    while (1) {
        # Consuming messages
        my $messages = $consumer->fetch(
            $topic_name,                      # topic
            0,                              # partition
            $offset,                              # offset
            $DEFAULT_MAX_BYTES * 10              # Maximum size of MESSAGE(s) to receive
        );

        if ( $messages ) {
            foreach my $message ( @$messages ) {
                if ( $message->valid ) {
                    say 'payload    : ', $message->payload;
                    say 'key        : ', $message->key;
                    say 'offset     : ', $message->offset;
                    say 'next_offset: ', $message->next_offset;
                    say 'Attributes : ', $message->Attributes;
                    # https://stackoverflow.com/questions/31204201/apache-kafka-with-avro-and-schema-repo-where-in-the-message-does-the-schema-id
                    # [magic byte][schema id][actual message]
                    # magic byte is 0x0; next 4 bits are the schema -> convert into an int
                    # to understand the next line read https://perldoc.perl.org/perlpacktut.html
                    # https://avro.apache.org/docs/current/spec.html#single_object_encoding
#                     Single object encoding specification
#                         Single Avro objects are encoded as follows:
#
#                     A two-byte marker, C3 01, to show that the message is Avro and uses this single-record format (version 1).
# The 8-byte little-endian CRC-64-AVRO fingerprint of the object's schema
# The Avro object encoded using Avro's binary encoding
#                     Erik::log("Start Hex Dump");
#                     my $payload = $message->payload;
                    my $payload = $message->payload;
                    open(my $fh, '>', '/tmp/avro_message') || die("UNable to open file for write: $!\n");
                    print $fh $payload;
                    close($fh);

                    Erik::dump(payload => $payload);
                    my @lines = `hexdump -c /tmp/avro_message`;
                    Erik::dump(hexdump => \@lines);
                    Erik::log("Finish Hex Dump");
                    Erik::dump(Unpackage => [unpack("a4a*", $payload)]);
                    my ($magic, $schema_id, $msg) = unpack("b2a8xa*", $payload);
                    Erik::log("magic: $magic");
                    Erik::log("schema_id: $schema_id");
                    Erik::log("msg: $msg");
                    # Erik::dump(message => $message, 3);
                } else {
                    say 'error      : ', $message->error;
                }
                exit;
                $offset = $message->next_offset;
            }
        }
        sleep(1);
    }
} catch {
    my $error = $_;
    if ( blessed( $error ) && $error->isa( 'Kafka::Exception' ) ) {
        warn 'Error: (', $error->code, ') ',  $error->message, "\n";
        exit;
    } else {
        die $error;
    }
};

END {
    # Closes the consumer and cleans up
    undef $consumer;
    $connection->close;
    undef $connection;
};