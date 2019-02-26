package com.github.burkaa01.consumerproducer.consumer;

import com.github.burkaa01.consumerproducer.producer.ExampleProducer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class ExampleConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleConsumer.class);

    @Autowired
    private ExampleProducer exampleProducer;

    @KafkaListener(topics = "${topics.consume-from}", containerFactory = "stringListenerFactory")
    public void listen(ConsumerRecord<String, String> consumerRecord, Acknowledgment ack) {
        String consumerValue = consumerRecord.value();
        LOGGER.info("Received record: '{}' with key: '{}'", consumerValue, consumerRecord.key());

        exampleProducer.produce(consumerValue, consumerRecord.headers());

        ack.acknowledge();
        LOGGER.info("Message acknowledged");
    }
}
