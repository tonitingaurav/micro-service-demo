package com.tonitingaurav.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEncryptableProperties
@EnableSwagger2
@SpringBootApplication
public class EmployeeApplicationStartup {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplicationStartup.class, args);
	}
}
