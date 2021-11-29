package com.tonitingaurav.microservice.configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.assertj.core.util.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Nitin Agrawal", "http://www.google.com", "tonitingaurav@gmail.com");

	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json", "application/xml"));

	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome API Title", //
			"Awesome API Description", //
			"1.0", //
			"urn:tos", //
			DEFAULT_CONTACT, //
			"Apache 2.0", //
			"http://www.apache.org/licenses/LICENSE-2.0", //
			Lists.newArrayList());

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2) //
				.apiInfo(DEFAULT_API_INFO) //
				.produces(DEFAULT_PRODUCES_AND_CONSUMES) //
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES) //
				.select().apis(RequestHandlerSelectors.basePackage("com.tonitingaurav.microservice.controller") //
						.and(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))) //
				.build();

	}
}
