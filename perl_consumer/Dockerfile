FROM perl:5.18
MAINTAINER Erik Tank <erik.tank@ticketmaster.com>

RUN echo 'alias ll="ls -al"' >> ~/.bashrc;

RUN apt-get update; apt-get -y install cpanminus bsdmainutils;
RUN cpanm install Kafka::Consumer JSON::XS Regexp::Common Error::Simple Object::Tiny IO::String LWP::Simple

WORKDIR /modules
ENV PERL5LIB /modules
COPY Erik.pm /modules
COPY Avro-1.9.0.tar.gz /modules
RUN tar -zxf Avro-1.9.0.tar.gz; cd Avro-1.9.0; perl Makefile.PL; make; make install; cd ..; rm -fr Avro-1.9.0*;

WORKDIR /code
COPY code/* /code/
