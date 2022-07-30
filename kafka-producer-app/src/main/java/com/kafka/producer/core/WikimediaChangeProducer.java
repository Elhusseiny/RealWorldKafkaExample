package com.kafka.producer.core;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;

@Slf4j
@Service
public class WikimediaChangeProducer {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage() throws InterruptedException //once called, kafka topic is filled ( below we specified the topic )
	{
		EventHandler eventHandler = new WikiMediaChangeHandler(kafkaTemplate , "wikimedia_recentchange") ;
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";
		EventSource.Builder builder = new EventSource.Builder(eventHandler , URI.create(url));
		EventSource eventSource = builder.build();
		eventSource.start();
		Thread.sleep(10000);



	}

}
