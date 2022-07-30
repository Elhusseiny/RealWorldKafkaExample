package com.kafka.demo.core;

import com.kafka.demo.entity.WikimediaData;
import com.kafka.demo.repository.wikimediaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {
	@Autowired
	private wikimediaRepository repository ;

	@KafkaListener(topics = "wikimedia_recentchange" , groupId = "myGroup")
	public void consume(String message)
	{
		WikimediaData data = new WikimediaData() ;
		data.setWikiData(message);
		repository.save(data);
		log.info("message received: " + message);
	}
}
