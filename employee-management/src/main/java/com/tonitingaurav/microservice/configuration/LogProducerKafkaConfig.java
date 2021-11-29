package com.tonitingaurav.microservice.configuration;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.stream.config.BindingProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.router.AbstractMappingMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
@ConfigurationProperties(prefix = "spring.cloud.stream.bindings")
public class LogProducerKafkaConfig {

	public static final String KAFKA_LOG_PUBLISHER = "kafka-log-publisher";

	@Autowired
	private KafkaBinders binders;

	@Bean(KAFKA_LOG_PUBLISHER)
	public MessageChannel kafkaLogPublisher() {
		return new DirectChannel();
	}

	@Bean
	@ServiceActivator(inputChannel = KAFKA_LOG_PUBLISHER)
	public AbstractMappingMessageRouter getMessageHandler() {
		return new AbstractMappingMessageRouter() {

			@Override
			protected List<Object> getChannelKeys(Message<?> message) {
				BindingProperties bindingProperties = binders.getBindings().get(KAFKA_LOG_PUBLISHER);
				return Collections.singletonList(bindingProperties.getDestination());
			}
		};
	}
}
