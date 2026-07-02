package com.nexvitalssupport.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

@Component
public class AgentClient {

	@Value("${app.agent.base-url}")
	private String agentBaseUrl;

	private final RestTemplate restTemplate = new RestTemplate();
	private final ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * Send message to NexBot ADK agent microservice
	 * Endpoint: https://nexvitalssupportmicroservice.onrender.com/chat
	 */
	public String sendMessage(String message, String sessionId) {

		// Agent not configured yet — return a placeholder reply
		if (agentBaseUrl == null || agentBaseUrl.isBlank()) {
			return "The chatbot is currently being set up. Please check back soon!";
		}

		try {
			// Build request payload
			Map<String, Object> requestBody = new HashMap<>();
			requestBody.put("message", message);
			requestBody.put("sessionId", sessionId);
			requestBody.put("timestamp", System.currentTimeMillis());

			// Call agent endpoint
			String agentUrl = agentBaseUrl.replaceAll("/$", "") + "/chat";
			
			@SuppressWarnings("unchecked")
			Map<String, Object> response = restTemplate.postForObject(
					agentUrl,
					requestBody,
					Map.class
			);

			// Extract reply from response
			if (response != null) {
				// Handle different response formats
				if (response.get("reply") != null) {
					return response.get("reply").toString();
				}
				if (response.get("response") != null) {
					return response.get("response").toString();
				}
				if (response.get("message") != null) {
					return response.get("message").toString();
				}
			}

			return "Sorry, I didn't get a proper response from the assistant. Please try again.";

		} catch (RestClientException e) {
			System.err.println("❌ Agent connection error: " + e.getMessage());
			return "Sorry, the assistant is currently unavailable. Please try again later.";
		} catch (Exception e) {
			System.err.println("❌ Unexpected error communicating with agent: " + e.getMessage());
			return "An unexpected error occurred. Please try again.";
		}
	}

	/**
	 * Health check for agent service by sending test message to /chat
	 */
	public boolean isAgentAvailable() {
		if (agentBaseUrl == null || agentBaseUrl.isBlank()) {
			System.out.println("⚠️ Agent URL is not configured!");
			return false;
		}

		try {
			String chatUrl = agentBaseUrl.replaceAll("/$", "") + "/chat";
			System.out.println("🔍 Testing agent at: " + chatUrl);
			
			// Send test message to verify agent is responding
			Map<String, Object> testRequest = new HashMap<>();
			testRequest.put("message", "health-check");
			testRequest.put("sessionId", "health-check-" + System.currentTimeMillis());
			
			@SuppressWarnings("unchecked")
			Map<String, Object> response = restTemplate.postForObject(
					chatUrl,
					testRequest,
					Map.class
			);
			
			if (response != null && response.get("reply") != null) {
				System.out.println("✅ Agent is available!");
				return true;
			}
			
			System.out.println("⚠️ Agent returned empty response");
			return false;
			
		} catch (Exception e) {
			System.err.println("❌ Agent unavailable: " + e.getMessage());
			return false;
		}
	}
}