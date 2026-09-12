package com.cutomersupport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cutomersupport.dto.request.GrievanceRequest;
import com.cutomersupport.dto.response.ApiResponse;
import com.cutomersupport.mail.MailDispatcher;
import com.cutomersupport.model.Grievance;
import com.cutomersupport.repository.GrievanceRepository;

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
        grievance.setClientID(request.getClientID());
        grievance.setGrievanceCatagory(request.getGrievanceCatagory());
        grievance.setComplaint(request.getComplaint());
        grievance.setComplainedAt(LocalDateTime.now());

        grievanceRepository.save(grievance);

        mailDispatcher.sendGrievanceAckMail(
            request.getEmailId(),
            request.getGrievanceCatagory()
        );

        return new ApiResponse<>(
            true,
            "Your support request has been submitted. We'll get back to you soon."
        );
    }
}