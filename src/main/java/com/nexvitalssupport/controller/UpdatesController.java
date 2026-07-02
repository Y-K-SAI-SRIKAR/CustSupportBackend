package com.nexvitalssupport.controller;

import com.nexvitalssupport.dto.response.UpdatesResponse;
import com.nexvitalssupport.service.UpdatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/updates")
public class UpdatesController {

	@Autowired
	private UpdatesService updatesService;

	@GetMapping
	public ResponseEntity<List<UpdatesResponse>> getLatestUpdates() {
		List<UpdatesResponse> updates = updatesService.getLatestUpdates();
		return ResponseEntity.ok(updates);
	}
}