package com.tonitingaurav.microservice.event.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.tonitingaurav.microservice.audit.Log;
import com.tonitingaurav.microservice.configuration.LogProducerKafkaConfig;

@Component
public class LogEventPublisher {

	@Autowired
	@Qualifier(LogProducerKafkaConfig.KAFKA_LOG_PUBLISHER)
	MessageChannel messageChannel;

	public void logMessage(Log log) {
		Message<Log> message = MessageBuilder.withPayload(log).build();
		messageChannel.send(message);
	}

}
