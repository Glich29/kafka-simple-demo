package org.sbislava.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.sbislava.kafka.utils.KafkaUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ConsumerApp {

    public static void main(String[] args) {
        String groupId = args.length > 0 ? args[0] : "java-app";
        List<String> topics = args.length > 0 ? new ArrayList<>(List.of(args).subList(1, args.length)) : List.of("topic1");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(
                KafkaUtils.createConsumerConfig(m -> m.put(ConsumerConfig.GROUP_ID_CONFIG, groupId)));

        consumer.subscribe(topics);

        while (true) {
            ConsumerRecords<String, String> result = consumer.poll(Duration.ofSeconds(10));
            System.out.println("Read: " + result.count());

            result.forEach(record -> {
                System.out.println("Message [" + record.topic() + "].[" + record.partition() + "]: "
                        + record.key() + " -> " + record.value());
            });
        }


    }
}
