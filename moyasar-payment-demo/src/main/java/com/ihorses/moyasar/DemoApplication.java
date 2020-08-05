package com.ihorses.moyasar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoApplication {

	//private PaymentConfigProperties paymentConfigProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public RestTemplate moyasarClient(RestTemplateBuilder restTemplateBuilder, PaymentConfigProperties paymentConfigProps ) {
		return restTemplateBuilder
				.rootUri(paymentConfigProps.getBaseUrl())
				.basicAuthentication(paymentConfigProps.getUsername(), "")
				.build();
	}

}
