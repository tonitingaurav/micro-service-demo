package com.tonitingaurav.microservice.configuration;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.stream.config.BindingProperties;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableMap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ConfigurationProperties(prefix = "spring.cloud.stream")
@NoArgsConstructor
@Getter
@Setter
@Component
public class KafkaBinders {

	private Map<String, BindingProperties> bindings = ImmutableMap.of();
}
