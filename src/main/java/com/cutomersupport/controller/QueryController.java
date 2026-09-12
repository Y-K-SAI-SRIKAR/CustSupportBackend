package com.cutomersupport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cutomersupport.dto.request.QueryRequest;
import com.cutomersupport.dto.response.ApiResponse;
import com.cutomersupport.dto.response.QueryResponse;
import com.cutomersupport.integration.AgentClient;

import java.util.UUID;

@RestController
@RequestMapping("/api/query")
@CrossOrigin(origins = {"http://localhost:7777", "http://localhost:3000"})
public class QueryController {

	@Autowired
	private AgentClient agentClient;

	/**
	 * Send query to NexBot ADK chatbot
	 * POST /api/query/chat
	 * Request: { "message": "your question", "sessionId": "optional-session-id" }
	 * Response: { "success": true, "data": { "reply": "bot response", "sessionId": "..." }, "message": "..." }
	 */
	@PostMapping("/chat")
	public ApiResponse<QueryResponse> chat(@RequestBody QueryRequest request) {
		try {
			// Validate input
			if (request == null || request.getMessage() == null || request.getMessage().trim().isEmpty()) {
				return new ApiResponse<>(false, "Query message cannot be empty.");
			}

			// Generate session ID if not provided
			String sessionId = request.getSessionId() != null && !request.getSessionId().trim().isEmpty()
					? request.getSessionId()
					: UUID.randomUUID().toString();

			// Get response from NexBot agent
			String reply = agentClient.sendMessage(request.getMessage(), sessionId);

			// Build response
			QueryResponse response = new QueryResponse(reply);

			return new ApiResponse<>(true, "Query processed successfully.", response);

		} catch (Exception e) {
			return new ApiResponse<>(false, "Error processing query: " + e.getMessage());
		}
	}

	/**
	 * Health check - verify NexBot agent is available
	 * GET /api/query/health
	 */
	@GetMapping("/health")
	public ApiResponse<Boolean> checkAgentHealth() {
		boolean isHealthy = agentClient.isAgentAvailable();
		if (isHealthy) {
			return new ApiResponse<>(true, "NexBot is available.", true);
		} else {
			return new ApiResponse<>(false, "NexBot is currently unavailable.", false);
		}
	}
}