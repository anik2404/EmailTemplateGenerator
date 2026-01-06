package com.example.emailgenerator.service;

import com.example.emailgenerator.ai.GeminiClient;
import com.example.emailgenerator.dto.EmailRequest;
import com.example.emailgenerator.dto.EmailResponse;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final GeminiClient geminiClient;

    public EmailService(GeminiClient geminiClient) {
        this.geminiClient = geminiClient;
    }

    public EmailResponse generateEmail(EmailRequest request) {

        long startTime = System.currentTimeMillis();

        String prompt = "Write a short, " + request.getTone()
                + " email for " + request.getRecipientName()
                + " regarding " + request.getPurpose();

        String email = geminiClient.generateEmail(prompt);

        long endTime = System.currentTimeMillis();

        return new EmailResponse(email, endTime - startTime);
    }
}