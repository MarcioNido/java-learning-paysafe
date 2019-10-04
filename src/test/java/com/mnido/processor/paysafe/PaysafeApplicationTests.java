package com.mnido.processor.paysafe;

import com.mnido.processor.paysafe.json.*;
import com.mnido.processor.paysafe.services.PaysafeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaysafeApplicationTests {

	@Autowired
	private PaysafeService service;

	@Test
	public void testHealthCheck() {
		CardPaymentsMonitorResponse response = service.healthCheck();
		System.out.println(response.toString());
		assertEquals("READY", response.getStatus());
	}

	@Test
	public void testVerification() {

		CardPaymentsVerificationRequest request = new CardPaymentsVerificationRequest();
		request.setDescription("This is a test transaction");
		request.setCard(new Card("4111111111111111", new CardExpiry(10, 2021), "123"));
		request.setCustomerIp("127.0.0.1");
		request.setMerchantRefNum(UUID.randomUUID().toString());
		request.setProfile(new Profile("Marcio", "Nido", "marcionido2@gmail.com" ));
		request.setBillingDetails(new BillingDetails(
				"40 High Park Avenue",
				"Toronto",
				"ON",
				"CA",
				"M6P2S1"
		));


		CardPaymentsVerificationResponse response = service.verification(request);
		System.out.println(response.toString());
		assertEquals("COMPLETED", response.getStatus());
	}
}
