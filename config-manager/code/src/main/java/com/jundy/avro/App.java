package com.jundy.avro;

import java.util.Properties;
import java.util.UUID;

import com.jundy.client.Market;
import com.jundy.client.RuleSet;
import com.jundy.client.Rules;
import com.jundy.client.Channel;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class App
{
    public static void main( String[] args )
    {
        String topicName = "config_user_rules";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        props.put("schema.registry.url", "http://localhost:8081");

        RuleSet clientRuleSet = RuleSet.newBuilder()
                .setConfigurableCustomerInfoObjFields("first_name,last_name")
                .setEnableInsurance(true)
                .build();
        Rules clientRules = Rules.newBuilder()
                .setChannel(Channel.INTERNET)
                .setUuid(UUID.randomUUID().toString())
                .setMarket(Market.UNITEDSTATES)
                .setRuleSet(clientRuleSet)
                .build();

        Rules clientRulesManual = new Rules();
        clientRulesManual.setChannel(Channel.INTERNET);
        clientRulesManual.setUuid(UUID.randomUUID().toString());
        clientRulesManual.setRuleSet(clientRuleSet);

        KafkaProducer producer = new KafkaProducer<>(props);
        ProducerRecord record = new ProducerRecord<>(topicName, messageName(clientRules), clientRules);
        producer.send(record);

        producer.flush();
        producer.close();
    }

    public static String messageName(Rules client) {
        System.out.println("Client: " + client.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(client.getChannel()).append("|").append(client.getMarket());

        if (client.getFeatureSet() != null) {
            sb.append("|").append(client.getFeatureSet().toString());
        }

        System.out.println("clientName: " + sb.toString());

        return sb.toString();
    }

}
