package com.kafka.producer.core;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
public class WikiMediaChangeHandler implements EventHandler {

	KafkaTemplate<String , String > kafkaTemplate ;
	String topic ;

	public WikiMediaChangeHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic ;
	}


	@Override
	public void onOpen() throws Exception {

	}

	@Override
	public void onClosed() throws Exception {

	}

	@Override
	public void onMessage(String s, MessageEvent messageEvent) throws Exception {
		log.info(messageEvent.getData());
		kafkaTemplate.send(topic,messageEvent.getData());
	}

	@Override
	public void onComment(String s) throws Exception {

	}

	@Override
	public void onError(Throwable throwable) {

	}
}
