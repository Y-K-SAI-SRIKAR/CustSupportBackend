package com.cutomersupport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cutomersupport.dto.response.UpdatesResponse;
import com.cutomersupport.service.UpdatesService;

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