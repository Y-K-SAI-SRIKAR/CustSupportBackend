package com.nexvitalssupport.service;

import com.nexvitalssupport.dto.response.UpdatesResponse;
import com.nexvitalssupport.model.Update;
import com.nexvitalssupport.repository.UpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UpdatesService {

	@Autowired
	private UpdateRepository updateRepository;

	public List<UpdatesResponse> getLatestUpdates() {
		List<Update> updates = updateRepository.findAllByOrderByPostedAtDesc();
		return updates.stream()
				.map(this::mapToResponse)
				.collect(Collectors.toList());
	}

	private UpdatesResponse mapToResponse(Update update) {
		UpdatesResponse response = new UpdatesResponse();

		response.setUpdateId(update.getUpdateId());
		response.setCategory(update.getCategory());
		response.setPostedBy(update.getPostedBy());
		response.setPostedAt(update.getPostedAt());

		response.setUpdateTitle(update.getUpdateTitle());
		response.setDateOfRelease(update.getDateOfRelease());
		response.setVersionNumber(update.getVersionNumber());
		response.setWhatChanged(update.getWhatChanged());
		response.setWhoItAffects(update.getWhoItAffects());

		response.setProtocolUpdate(update.getProtocolUpdate());
		response.setEffectiveFrom(update.getEffectiveFrom());
		response.setUpdateDescription(update.getUpdateDescription());
		response.setImplementingDateExpected(update.getImplementingDateExpected());

		response.setNoticeTitle(update.getNoticeTitle());
		response.setStartDateTime(update.getStartDateTime());
		response.setEndDateTime(update.getEndDateTime());
		response.setDetails(update.getDetails());

		response.setPartnerTitle(update.getPartnerTitle());
		response.setPartnerEffectiveFrom(update.getPartnerEffectiveFrom());
		response.setPartnerDescription(update.getPartnerDescription());

		response.setPolicyTitle(update.getPolicyTitle());
		response.setPolicyEffectiveDate(update.getPolicyEffectiveDate());
		response.setPolicyDescription(update.getPolicyDescription());

		response.setTeamDate(update.getTeamDate());
		response.setAchievementTitle(update.getAchievementTitle());
		response.setTeamDescription(update.getTeamDescription());

		return response;
	}

	public void notifySubscribersOfUpdate(Update update) {
		// TODO Auto-generated method stub
		
	}
}