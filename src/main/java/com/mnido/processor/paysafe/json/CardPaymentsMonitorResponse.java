package com.mnido.processor.paysafe.json;

public class CardPaymentsMonitorResponse {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CardPaymentsMonitorResponse{" +
                "status='" + status + '\'' +
                '}';
    }
}
