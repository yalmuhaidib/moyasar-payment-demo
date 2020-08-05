package com.ihorses.moyasar;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

@ConfigurationProperties(prefix = "ihorses.payment.client")
@Data
@NoArgsConstructor
public class PaymentConfigProperties {

	/**
	 * Spring restTemplate username used to connect to moyasar APIs 
	 */
	private String username;
	/**
	 * Spring restTemplate password used to connect to moyasar APIs 
	 */
	private String passowrd;
	
	private String baseUrl;
}
