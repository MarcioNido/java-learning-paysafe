package com.mnido.processor.paysafe.services;

import com.mnido.processor.paysafe.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class PaysafeService {

    private static final String BASE_URL="https://api.test.paysafe.com";
    private static final String ACCOUNT="1001561260";
    private static final String API_KEY="dGVzdF9tYXJjaW9uaWRvMjpCLXFhMi0wLTVkOTJhOTRmLTAtMzAyZDAyMTUwMDgzNjFmZTMwY2EzNTI2N2VhZTQ5ZDNkMjUxNDg1MzUzZDdiMThmZDIwMjE0NDViNTRhOWNlZDhkOTc4NGI0NTA1N2Y0Mjg1NDE4MTNhZWIxZTgxYw==";
    private static final String WRONG_API_KEY="blablabla";

    private RestTemplate restTemplate;

    @Autowired
    public PaysafeService(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public CardPaymentsMonitorResponse healthCheck()
    {
        String url = String.format("%s/cardpayments/monitor", BASE_URL);
        return this.restTemplate.getForObject(url, CardPaymentsMonitorResponse.class);
    }

    public CardPaymentsVerificationResponse verification()
    {
        String url = String.format("%s/cardpayments/v1/accounts/%s/verifications", BASE_URL, ACCOUNT);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, String.format("Basic %s", API_KEY));



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


        HttpEntity<CardPaymentsVerificationRequest> httpRequest = new HttpEntity<>(request, headers);

        return this.restTemplate.postForObject(url, httpRequest, CardPaymentsVerificationResponse.class);
    }



}
