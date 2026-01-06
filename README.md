# AI-Powered Email Template Generator Service  

## Technology Stack
- Java 17  
- Spring Boot  
- Maven  
- REST API  
- Google Gemini API  

## API Specification

### Generate Email Template

HTTP Method  
POST

Endpoint  
/email/generate

Request Body
```json
{
  "purpose": "payment reminder",
  "recipientName": "Anik",
  "tone": "polite"
}
```

Sample Response
```json
{
  "emailTemplate": "Dear Anik,\n\nThis is a polite reminder regarding your pending payment.\n\nRegards,\nSupport Team",
  "responseTimeMs": 1042
}
```

## Application Flow
1. Client sends a POST request with email details.
2. Controller receives the request.
3. Service layer constructs an AI prompt.
4. Gemini AI generates the email content.
5. Generated email and response time are returned.
6. A fallback message is returned if the AI service fails.

## Project Structure
```
email-generator
├── pom.xml
└── src
    └── main
        ├── java
        │   └── com.example.emailgenerator
        │       ├── controller
        │       ├── service
        │       ├── ai
        │       └── dto
        └── resources
            └── application.properties
```

## Gemini AI Integration
Gemini API is integrated using REST calls.  
The prompt is dynamically generated using user input.  
The AI response is parsed and returned as plain email text.  
Prompt design is kept simple and deterministic to ensure consistent output.

## Environment Configuration
The Gemini API key is configured using an environment variable.

```powershell
setx GEMINI_API_KEY "YOUR_GEMINI_API_KEY"
```

Restart the terminal or IDE after setting the variable.

## Running the Application
Navigate to the directory containing `pom.xml` and run:

```powershell
mvn clean
mvn spring-boot:run
```

The application runs on port 8080.

## Error Handling
Basic fallback handling is implemented.  
If the Gemini API is unavailable, a predefined email template is returned.  
This ensures application stability during external service failures.

## AI Prompt Design Explanation

The AI prompts were designed to be simple, clear, and deterministic so that the generated email remains short, professional, and relevant to the user’s intent.
Each prompt is constructed dynamically using three user inputs:
Purpose of the email
Recipient name
Desired tone (for example, polite or professional)
These inputs are combined into a single natural-language instruction, such as:
“Write a short, polite email for Anik regarding payment reminder.”
The prompt avoids unnecessary context or extra instructions to ensure:
Consistent and predictable output
Clear focus on email content only
Appropriate tone based on user input
Reduced chances of overly long or irrelevant responses
This approach keeps the AI behavior controlled and aligns with real-world backend use cases where concise and reliable output is required.
