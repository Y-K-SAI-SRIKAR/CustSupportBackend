package com.nexvitalssupport.service;

import com.nexvitalssupport.dto.request.GrievanceRequest;
import com.nexvitalssupport.dto.response.ApiResponse;
import com.nexvitalssupport.mail.MailDispatcher;
import com.nexvitalssupport.model.Grievance;
import com.nexvitalssupport.repository.GrievanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GrievanceService {

	@Autowired
	private GrievanceRepository grievanceRepository;

	@Autowired
	private MailDispatcher mailDispatcher;

	public ApiResponse<Void> submitGrievance(GrievanceRequest request) {

		Grievance grievance = new Grievance();
		grievance.setEmailId(request.getEmailId());
		grievance.setNexVitalsDeviceId(request.getNexVitalsDeviceId());
		grievance.setGrievanceCatagory(request.getGrievanceCatagory());
		grievance.setComplaint(request.getComplaint());
		grievance.setComplainedAt(LocalDateTime.now());

		grievanceRepository.save(grievance);

		mailDispatcher.sendGrievanceAckMail(request.getEmailId(), request.getGrievanceCatagory());

		return new ApiResponse<>(true, "Your grievance has been submitted. We'll get back to you soon.");
	}
}