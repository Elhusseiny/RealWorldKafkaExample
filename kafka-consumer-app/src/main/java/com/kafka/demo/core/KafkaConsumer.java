package com.kafka.demo.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {
	@KafkaListener(topics = "wikimedia_recentchange" , groupId = "myGroup")
	public void consume(String message)
	{
		log.info("message received: " + message);
	}
}
