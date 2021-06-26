package com.tonitingaurav.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableConfigServer
@EnableEncryptableProperties
@EnableEurekaClient
public class ConfigurationServerStartup {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationServerStartup.class, args);
	}
}
