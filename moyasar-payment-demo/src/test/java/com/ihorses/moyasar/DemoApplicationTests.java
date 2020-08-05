package com.ihorses.moyasar;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.ihorses.moyasar.model.PaymentList;
import com.ihorses.moyasar.model.PaymentSource;

@SpringBootTest
class DemoApplicationTests {
	
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

	private RestTemplate moyasarClient;
	
	
	@Autowired
	public DemoApplicationTests(RestTemplate moyasarClient) {
		super();
		this.moyasarClient = moyasarClient;
	}

	
	@Test
	public void paymentSourcePojo() {
		PaymentSource ps = new PaymentSource();
		ps.setCompany("Test");
		assertEquals("Test", ps.getCompany());
	}
	
	@Test
	public void getAllPayments() {
		PaymentList pl = moyasarClient.getForObject("/v1/payments/", PaymentList.class);
		assertNotNull(pl, "PaymentList Object is null");
		assertNotNull(pl.getPayments(), "payment list is null");
		assertThat(pl.getPayments(), not(empty()));
		assertThat(pl.getPayments(), hasSize(greaterThan(3)));
		
		
		//just to show it in the log, should not be done as test assertions already prove it is working
		pl.getPayments().forEach((payment) -> {
			log.info("payment ID: {}, status: {}, Date: {}, update Date: {}", payment.getId(), payment.getStatus(), payment.getCreateDate(), payment.getUpdateDate());
		});
	}
	
	@Test
	public void getPaymentById() {
		final String paymentId = "cf190371-6df7-43bd-9657-4c6d60a1ef74";
		
		PaymentList pl = moyasarClient.getForObject("/v1/payments/?id={paymentId}", PaymentList.class, paymentId );
		
		assertNotNull(pl, "PaymentList Object is null");
		assertNotNull(pl.getPayments(), "payment list is null");
		assertThat(pl.getPayments(), not(empty()));
		assertThat(pl.getPayments(), hasSize(1));
		assertThat(pl.getPayments(), 
				hasItem(
						hasProperty("id", is(paymentId))
						));
	}

}
