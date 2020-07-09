package com.jundy.avro;

import java.util.*;

import org.apache.avro.specific.SpecificData;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.jundy.client.Rules;
import com.jundy.client.RuleSet;
import org.apache.kafka.common.TopicPartition;

public class App
{
    public static void main( String[] args )
    {
        String topicName = "config_user_rules";

        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "avro_presentation");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "io.confluent.kafka.serializers.KafkaAvroDeserializer");
        props.put("schema.registry.url", "http://localhost:8081");

        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        System.out.println("Trying to connect to the consumer");
        try (KafkaConsumer<String, Rules> consumer = new KafkaConsumer<>(props)) {
            System.out.println("Subscribe to " + topicName);
            consumer.subscribe(Arrays.asList(topicName));

            //https://stackoverflow.com/questions/41008610/kafkaconsumer-0-10-java-api-error-message-no-current-assignment-for-partition
            // "Also keep in mind, that subscribe() and assign() are lazy -- thus, you also need to do a "dummy call" to poll() before you can use seek()."
            ConsumerRecords<String, Rules> recordsToBeIgnored = consumer.poll(100);

            consumer.seekToBeginning(new TopicPartition(topicName, 0));

            while (true) {
//                System.out.println("Poll ....");
                ConsumerRecords<String, Rules> records = consumer.poll(100);
                for (ConsumerRecord<String, Rules> record : records) {
                    System.out.println("Record Received !!!!!");
                    System.out.println("Offset: " + record.offset());
                    System.out.println(record.key());
                    System.out.println(record.value());

                    Rules rules = (Rules) SpecificData.get().deepCopy(Rules.SCHEMA$, record.value());
                    System.out.println("rules parsed:\n" + rules);
                    RuleSet ruleSet = rules.getRuleSet();
                    if (ruleSet.getEnableInsurance()) {
                        System.out.println(rules.getChannel() + " is allowed to sell insurance");
                    }
                }
            }
        }
    }
}
