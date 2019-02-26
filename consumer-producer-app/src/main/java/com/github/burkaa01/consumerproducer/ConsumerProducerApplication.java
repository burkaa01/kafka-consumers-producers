package com.github.burkaa01.consumerproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class ConsumerProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerProducerApplication.class, args);
	}
}
