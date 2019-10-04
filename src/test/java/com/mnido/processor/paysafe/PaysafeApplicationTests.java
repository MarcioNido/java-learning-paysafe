package com.mnido.processor.paysafe;

import com.mnido.processor.paysafe.json.CardPaymentsMonitorResponse;
import com.mnido.processor.paysafe.json.CardPaymentsVerificationResponse;
import com.mnido.processor.paysafe.services.PaysafeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaysafeApplicationTests {

	@Autowired
	private PaysafeService service;

	@Test
	public void testHealthCheck() {
		CardPaymentsMonitorResponse response = service.healthCheck();
		assertEquals("READY", response.getStatus());
	}

	@Test
	public void testVerification() {
		CardPaymentsVerificationResponse response = service.verification();
		assertEquals("COMPLETED", response.getStatus());
	}
}
