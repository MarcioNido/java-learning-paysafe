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

    public CardPaymentsVerificationResponse verification(CardPaymentsVerificationRequest request)
    {
        String url = String.format("%s/cardpayments/v1/accounts/%s/verifications", BASE_URL, ACCOUNT);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, String.format("Basic %s", API_KEY));
        HttpEntity<CardPaymentsVerificationRequest> httpRequest = new HttpEntity<>(request, headers);

        return this.restTemplate.postForObject(url, httpRequest, CardPaymentsVerificationResponse.class);
    }



}
