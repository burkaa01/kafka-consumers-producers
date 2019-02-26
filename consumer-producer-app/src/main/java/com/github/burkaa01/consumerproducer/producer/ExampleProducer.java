package com.github.burkaa01.consumerproducer.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Headers;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ExampleProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleProducer.class);
    private static final String CSV_DELIMITER = ",";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topics.produce-to}")
    String produceToTopic;

    public void produce(String consumerValue, Headers consumerHeaders) {
        if (Strings.isBlank(consumerValue)) {
            LOGGER.info("Did not produce a record");
            return;
        }

        String[] consumerValues = consumerValue.split(CSV_DELIMITER);
        if (consumerValues.length != 2) {
            LOGGER.info("Did not produce a record");
            return;
        }

        String lastName = consumerValues[0];
        String firstName = consumerValues[1];

        String key = null;
        String producerValue = firstName + " " + lastName;

        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(
                produceToTopic,
                null,
                key,
                producerValue,
                consumerHeaders);
        kafkaTemplate.send(producerRecord);

        LOGGER.info("Produced record: '{}' with key: '{}'", producerValue, key);
    }
}
