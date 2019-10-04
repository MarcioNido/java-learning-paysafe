package com.mnido.processor.paysafe.json;

public class Card {

    private String cardNum;
    private CardExpiry cardExpiry;
    private String cvv;
//    private String type;
//    private String lastDigits;

    public Card(String cardNum, CardExpiry cardExpiry, String cvv) {
        this.cardNum = cardNum;
        this.cardExpiry = cardExpiry;
        this.cvv = cvv;
    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getLastDigits() {
//        return lastDigits;
//    }
//
//    public void setLastDigits(String lastDigits) {
//        this.lastDigits = lastDigits;
//    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public CardExpiry getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(CardExpiry cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
