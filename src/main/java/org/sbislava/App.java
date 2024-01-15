package org.sbislava;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.sbislava.kafka.utils.KafkaUtils;

/**
 * Hello world!
 *
 */
public class App {
    public static final String TOPIC = "topic1";
    public static void main( String[] args ) {
//        System.out.println( "Hello World!" );
        KafkaProducer<String, String> producer = new KafkaProducer<>(KafkaUtils.producerConfig);
        for (int i=0; i<2; i++) {
            System.out.println(TOPIC + "-" + Integer.toString(i) + ":" + Integer.toString(i));
            producer.send(new ProducerRecord<>(TOPIC, Integer.toString(i), Integer.toString(i)));
            producer.flush();
        }

        producer.close();

    }
}
