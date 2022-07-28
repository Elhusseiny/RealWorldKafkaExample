package com.kafka.producer;

import com.kafka.producer.core.WikimediaChangeProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {

	@Autowired
	WikimediaChangeProducer producer;

	public static void main(String[] args)
	{
		SpringApplication.run(KafkaProducerApplication.class);

	}

	@Override
	public void run(String... args) throws Exception {
		producer.sendMessage();
	}
}
