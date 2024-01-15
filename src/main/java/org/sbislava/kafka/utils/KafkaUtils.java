package org.sbislava.kafka.utils;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class KafkaUtils {

    public static final String HOST = "127.0.0.1:9092";

    private KafkaUtils() {

    }

    public static Map<String, Object> producerConfig = Map.of(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, HOST,
            ProducerConfig.ACKS_CONFIG, "all",
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class
    );

    public static Map<String, Object> createProducerConfig(Consumer<Map<String, Object>> builder) {
        Map<String, Object> map = new HashMap<>(producerConfig);
        builder.accept(map);
        return map;
    }

    public static Map<String, Object> consumerConfig = Map.of(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, HOST,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName(),
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
            ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"
    );

    public static Map<String, Object> createConsumerConfig(Consumer<Map<String, Object>> builder) {
        Map<String, Object> map = new HashMap<>(consumerConfig);
        builder.accept(map);
        return map;
    }




}
