package com.example.emailgenerator.dto;

public class EmailRequest {
    private String purpose;
    private String recipientName;
    private String tone;

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public String getRecipientName() { return recipientName; }
    public void setRecipientName(String recipientName) { this.recipientName = recipientName; }

    public String getTone() { return tone; }
    public void setTone(String tone) { this.tone = tone; }
}