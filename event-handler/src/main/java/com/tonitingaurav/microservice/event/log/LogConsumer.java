package com.tonitingaurav.microservice.event.log;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tonitingaurav.microservice.audit.Log;

@Configuration
public class LogConsumer {

	@Bean
	Consumer<Log> audit(){
		return log -> {
			System.out.println(log.getMessage());
		};
	}
}
