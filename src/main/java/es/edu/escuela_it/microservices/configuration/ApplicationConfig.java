package es.edu.escuela_it.microservices.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.ToString;

@Configuration
@Data
@ToString
@ConfigurationProperties(prefix="app")
public class ApplicationConfig {

	private String name;

	private Integer year;

	private String edition;

	private String[] countries;
	
	@Value(value="${java_home}")
	private String jav;

}
