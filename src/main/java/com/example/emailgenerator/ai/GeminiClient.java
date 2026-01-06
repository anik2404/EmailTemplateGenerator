package com.example.emailgenerator.ai;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GeminiClient {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public GeminiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String generateEmail(String prompt) {

        String url =
            "https://generativelanguage.googleapis.com/v1/models/gemini-3.0-flash-preview:generateContent?key="
            + apiKey;

        // Request body (CORRECT FORMAT)
        Map<String, Object> textPart = new HashMap<>();
        textPart.put("text", prompt);

        Map<String, Object> content = new HashMap<>();
        content.put("parts", List.of(textPart));

        Map<String, Object> body = new HashMap<>();
        body.put("contents", List.of(content));

        try {
            Map<?, ?> response = restTemplate.postForObject(url, body, Map.class);

            if (response == null) {
                return "Gemini response was null.";
            }

            List<?> candidates = (List<?>) response.get("candidates");
            if (candidates == null || candidates.isEmpty()) {
                return "Gemini returned no candidates.";
            }

            Map<?, ?> firstCandidate = (Map<?, ?>) candidates.get(0);
            Map<?, ?> contentMap = (Map<?, ?>) firstCandidate.get("content");
            List<?> parts = (List<?>) contentMap.get("parts");

            return parts.get(0).toString().replace("{text=", "").replace("}", "");

        } catch (Exception e) {
            e.printStackTrace();
            return "Dear Customer,\n\nUnable to generate email at the moment.\n\nRegards,\nSupport Team";
        }
    }
}
