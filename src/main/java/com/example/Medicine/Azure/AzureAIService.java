package com.example.Medicine.Azure;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AzureAIService {

    @Value("${azure.ai.key}")
    private String apiKey;

    @Value("${azure.ai.endpoint}")
    private String endpoint;

    private final RestTemplate rest = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    public JsonNode analyzeText(String text) throws Exception {

        String url = endpoint + "language/:analyze-text?api-version=2023-04-01";

        String body = """
        {
          "kind": "SentimentAnalysis",
          "parameters": { "modelVersion": "latest" },
          "analysisInput": {
            "documents": [
              { "id": "1", "language": "es", "text": "%s" }
            ]
          }
        }
        """.formatted(text);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Ocp-Apim-Subscription-Key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = rest.exchange(url, HttpMethod.POST, entity, String.class);

        return mapper.readTree(response.getBody());
    }
}