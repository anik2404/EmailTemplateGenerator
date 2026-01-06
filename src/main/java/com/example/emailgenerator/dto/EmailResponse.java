package com.example.emailgenerator.dto;

public class EmailResponse {
    private String emailTemplate;
    private long responseTimeMs;

    public EmailResponse(String emailTemplate, long responseTimeMs) {
        this.emailTemplate = emailTemplate;
        this.responseTimeMs = responseTimeMs;
    }

    public String getEmailTemplate() { return emailTemplate; }
    public long getResponseTimeMs() { return responseTimeMs; }
}