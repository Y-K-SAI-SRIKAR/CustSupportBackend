package com.cutomersupport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cutomersupport.dto.response.UpdatesResponse;
import com.cutomersupport.model.Update;
import com.cutomersupport.repository.UpdateRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UpdatesService {

    @Autowired
    private UpdateRepository updateRepository;


    public List<UpdatesResponse> getLatestUpdates() {

        List<Update> updates =
                updateRepository.findAllByOrderByPostedAtDesc();

        return updates.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }


    private UpdatesResponse mapToResponse(Update update) {

        UpdatesResponse response = new UpdatesResponse();

        // ---------- Common ----------

        response.setUpdateId(
                update.getUpdateId()
        );

        response.setCategory(
                update.getCategory()
        );

        response.setPostedBy(
                update.getPostedBy()
        );

        response.setPostedAt(
                update.getPostedAt()
        );


        // ---------- Product Updates ----------

        response.setUpdateTitle(
                update.getUpdateTitle()
        );

        response.setDateOfRelease(
                update.getDateOfRelease()
        );

        response.setVersionNumber(
                update.getVersionNumber()
        );

        response.setWhatChanged(
                update.getWhatChanged()
        );

        response.setWhoItAffects(
                update.getWhoItAffects()
        );


        // ---------- Workflow Updates ----------

        response.setWorkflowUpdate(
                update.getWorkflowUpdate()
        );

        response.setEffectiveFrom(
                update.getEffectiveFrom()
        );

        response.setUpdateDescription(
                update.getUpdateDescription()
        );

        response.setImplementationDate(
                update.getImplementationDate()
        );


        // ---------- Maintenance Notices ----------

        response.setNoticeTitle(
                update.getNoticeTitle()
        );

        response.setStartDateTime(
                update.getStartDateTime()
        );

        response.setEndDateTime(
                update.getEndDateTime()
        );

        response.setDetails(
                update.getDetails()
        );


        // ---------- Feature Releases ----------

        response.setFeatureTitle(
                update.getFeatureTitle()
        );

        response.setFeatureReleaseDate(
                update.getFeatureReleaseDate()
        );

        response.setFeatureDescription(
                update.getFeatureDescription()
        );


        // ---------- Policy Updates ----------

        response.setPolicyTitle(
                update.getPolicyTitle()
        );

        response.setPolicyEffectiveDate(
                update.getPolicyEffectiveDate()
        );

        response.setPolicyDescription(
                update.getPolicyDescription()
        );


        // ---------- Team Announcements ----------

        response.setTeamDate(
                update.getTeamDate()
        );

        response.setAchievementTitle(
                update.getAchievementTitle()
        );

        response.setTeamDescription(
                update.getTeamDescription()
        );


        return response;
    }


    public void notifySubscribersOfUpdate(Update update) {

        // TODO: Implement if subscriber notification
        // is required directly from this service.

    }
}