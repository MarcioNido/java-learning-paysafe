package com.mnido.processor.paysafe.json;

import java.util.Date;

public class CardPaymentsVerificationResponse {

//    private Link[] links;
    private String id;
    private String merchantRefNum;
    private Card card;
    private String authCode;
    private Profile profile;
    private BillingDetails billingDetails;
    private String customerIp;
    private String description;
    private Date txnTime;
    private String currencyCode;
    private String avsResponse;
    private String cvvVerification;
    private String status;

//    public Link[] getLinks() {
//        return links;
//    }

//    public void setLinks(Link[] links) {
//        this.links = links;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchantRefNum() {
        return merchantRefNum;
    }

    public void setMerchantRefNum(String merchantRefNum) {
        this.merchantRefNum = merchantRefNum;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public BillingDetails getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTxnTime() {
        return txnTime;
    }

    public void setTxnTime(Date txnTime) {
        this.txnTime = txnTime;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getAvsResponse() {
        return avsResponse;
    }

    public void setAvsResponse(String avsResponse) {
        this.avsResponse = avsResponse;
    }

    public String getCvvVerification() {
        return cvvVerification;
    }

    public void setCvvVerification(String cvvVerification) {
        this.cvvVerification = cvvVerification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
