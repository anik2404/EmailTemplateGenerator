package com.example.emailgenerator.controller;

import com.example.emailgenerator.dto.EmailRequest;
import com.example.emailgenerator.dto.EmailResponse;
import com.example.emailgenerator.service.EmailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/generate")
    public EmailResponse generateEmail(@RequestBody EmailRequest request) {
        return emailService.generateEmail(request);
    }
}