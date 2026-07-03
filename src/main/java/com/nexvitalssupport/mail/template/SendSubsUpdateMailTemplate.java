package com.nexvitalssupport.mail.template;

import org.springframework.stereotype.Component;

@Component
public class SendSubsUpdateMailTemplate {

	public String buildUpdateNotificationMail(String updateCategory, String updateTitle, 
											   String updateDescription, String versionNumber, 
											   String whatChanged, String whoItAffects,
											   String protocolUpdate, String effectiveFromDate,
											   String noticeTitle, String startDateTime, 
											   String endDateTime, String details,
											   String partnerTitle, String partnerEffectiveFrom,
											   String partnerDescription, String policyTitle,
											   String policyEffectiveDate, String policyDescription,
											   String achievementTitle, String teamDescription) {
		
		String htmlContent = "";
		
		// Handle null updateCategory safely
		if (updateCategory == null || updateCategory.isEmpty()) {
			htmlContent = buildGenericUpdateMail(updateTitle, updateDescription);
		} else {
			switch(updateCategory.toLowerCase()) {
				case "product-updates":
					htmlContent = buildProductUpdateMail(updateTitle, versionNumber, whatChanged, whoItAffects);
					break;
				case "workflow-announcements":
					htmlContent = buildWorkflowAnnouncementMail(protocolUpdate, effectiveFromDate, updateDescription);
					break;
				case "maintenance-notices":
					htmlContent = buildMaintenanceNoticeMail(noticeTitle, startDateTime, endDateTime, details);
					break;
				case "partnership-network-expansion":
					htmlContent = buildPartnershipMail(partnerTitle, partnerEffectiveFrom, partnerDescription);
					break;
				case "policy-compliance":
					htmlContent = buildPolicyComplianceMail(policyTitle, policyEffectiveDate, policyDescription);
					break;
				case "internal-team-announcements":
					htmlContent = buildTeamAnnouncementMail(achievementTitle, teamDescription);
					break;
				default:
					htmlContent = buildGenericUpdateMail(updateTitle, updateDescription);
					break;
			}
		}
		
		return htmlContent;
	}

	private String getCommonStyles() {
		return "    <style>\n" +
			"        * { margin: 0; padding: 0; }\n" +
			"        body { font-family: 'Noto Serif', serif; font-style: italic; font-weight: 300; background-color: #f5f5f5; color: #333333; }\n" +
			"        .email-container { max-width: 600px; margin: 20px auto; background-color: #ffffff; border: 1px solid #CCBEB1; border-radius: 8px; overflow: hidden; }\n" +
			"        .header { background-color: #4C84D0; color: white; padding: 30px 20px; text-align: center; border-bottom: 4px solid #B2DAE4; }\n" +
			"        .header h1 { font-size: 24px; font-weight: normal; margin-bottom: 5px; font-style: italic; }\n" +
			"        .header p { font-size: 14px; opacity: 0.9; font-style: italic; }\n" +
			"        .content { padding: 30px 20px; }\n" +
			"        .section { margin-bottom: 25px; }\n" +
			"        .section-title { font-size: 14px; font-weight: bold; color: #4C84D0; margin-bottom: 10px; text-transform: uppercase; letter-spacing: 1px; font-style: normal; }\n" +
			"        .section-content { font-size: 14px; color: #333333; line-height: 1.6; }\n" +
			"        .badge { display: inline-block; background-color: #B2DAE4; color: #4C84D0; padding: 6px 12px; border-radius: 4px; font-size: 12px; font-weight: bold; margin-bottom: 15px; font-style: normal; }\n" +
			"        .highlight-box { background-color: #fcfcfc; border-left: 4px solid #D8D4BC; padding: 15px; margin-bottom: 15px; font-style: italic; }\n" +
			"        .footer { background-color: #f9f9f9; padding: 20px; text-align: center; font-size: 12px; color: #ACC0D3; border-top: 1px solid #CCBEB1; }\n" +
			"        .footer a { color: #4C84D0; text-decoration: none; }\n" +
			"    </style>\n";
	}

	private String getFooterContent() {
		return "        <div class=\"footer\">\n" +
			"            <p><em>Smarter Vehicles. Faster Care. Safer Lives.</em></p>\n" +
			"            <p>Contact: nexvitalssupport@gmail.com</p>\n" +
			"        </div>\n";
	}

	private String buildProductUpdateMail(String updateTitle, String versionNumber, String whatChanged, String whoItAffects) {
		return "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n" + getCommonStyles() + "</head>\n<body>\n" +
			"    <div class=\"email-container\">\n" +
			"        <div class=\"header\">\n" +
			"            <h1>Product Update Notice</h1>\n" +
			"            <p>NexVitals Support - Release " + (versionNumber != null ? versionNumber : "Latest") + "</p>\n" +
			"        </div>\n" +
			"        <div class=\"content\">\n" +
			"            <p style=\"font-size: 16px; margin-bottom: 20px;\">Dear Stakeholder,</p>\n" +
			"            <p style=\"font-size: 14px; line-height: 1.6; margin-bottom: 20px;\">We are writing to inform you of a recent product update within the NexVitals ecosystem.</p>\n" +
			"            <div class=\"section\">\n" +
			"                <span class=\"badge\">Version " + (versionNumber != null ? versionNumber : "N/A") + "</span>\n" +
			"                <div class=\"section-title\">Update Title</div>\n" +
			"                <div class=\"section-content\">" + (updateTitle != null ? updateTitle : "Product Update Details") + "</div>\n" +
			"            </div>\n" +
			"            <div class=\"section\">\n" +
			"                <div class=\"section-title\">Modifications</div>\n" +
			"                <div class=\"highlight-box\">" + (whatChanged != null ? whatChanged.replaceAll("\n", "<br>") : "System enhancements have been applied.") + "</div>\n" +
			"            </div>\n" +
			"            <div class=\"section\">\n" +
			"                <div class=\"section-title\">Affected Users</div>\n" +
			"                <div class=\"section-content\">" + (whoItAffects != null ? whoItAffects.replaceAll("\n", "<br>") : "Please review the documentation for impact details.") + "</div>\n" +
			"            </div>\n" +
			"        </div>\n" + getFooterContent() +
			"    </div>\n</body>\n</html>";
	}

	private String buildWorkflowAnnouncementMail(String protocolUpdate, String effectiveFromDate, String updateDescription) {
		return "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n" + getCommonStyles() + "</head>\n<body>\n" +
			"    <div class=\"email-container\">\n" +
			"        <div class=\"header\">\n" +
			"            <h1>Workflow Announcement</h1>\n" +
			"            <p>Important Protocol Adjustments</p>\n" +
			"        </div>\n" +
			"        <div class=\"content\">\n" +
			"            <p style=\"font-size: 16px; margin-bottom: 20px;\">Dear Stakeholder,</p>\n" +
			"            <p style=\"font-size: 14px; line-height: 1.6; margin-bottom: 20px;\">Please be advised of upcoming adjustments to our operational workflow protocols.</p>\n" +
			"            <div class=\"section\">\n" +
			"                <div class=\"section-title\">Protocol Modification</div>\n" +
			"                <div class=\"section-content\">" + (protocolUpdate != null ? protocolUpdate : "Workflow update applied.") + "</div>\n" +
			"            </div>\n" +
			"            <div class=\"section\">\n" +
			"                <span class=\"badge\">Effective From: " + (effectiveFromDate != null ? effectiveFromDate : "Immediately") + "</span>\n" +
			"                <div class=\"section-title\">Description of Changes</div>\n" +
			"                <div class=\"highlight-box\">" + (updateDescription != null ? updateDescription.replaceAll("\n", "<br>") : "Please review the adjustments thoroughly.") + "</div>\n" +
			"            </div>\n" +
			"        </div>\n" + getFooterContent() +
			"    </div>\n</body>\n</html>";
	}

	private String buildMaintenanceNoticeMail(String noticeTitle, String startDateTime, String endDateTime, String details) {
		return "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n" + getCommonStyles() + "</head>\n<body>\n" +
			"    <div class=\"email-container\">\n" +
			"        <div class=\"header\">\n" +
			"            <h1>Maintenance Notification</h1>\n" +
			"            <p>Scheduled System Outage</p>\n" +
			"        </div>\n" +
			"        <div class=\"content\">\n" +
			"            <p style=\"font-size: 16px; margin-bottom: 20px;\">Dear Stakeholder,</p>\n" +
			"            <p style=\"font-size: 14px; line-height: 1.6; margin-bottom: 20px;\">We are scheduling essential maintenance on the NexVitals infrastructure.</p>\n" +
			"            <div class=\"section\">\n" +
			"                <div class=\"section-title\">Maintenance Window</div>\n" +
			"                <div class=\"highlight-box\">\n" +
			"                    <strong>Commencement:</strong> " + (startDateTime != null ? startDateTime : "Pending schedule") + "<br>\n" +
			"                    <strong>Conclusion:</strong> " + (endDateTime != null ? endDateTime : "Pending schedule") + "\n" +
			"                </div>\n" +
			"            </div>\n" +
			"            <div class=\"section\">\n" +
			"                <div class=\"section-title\">Notice Context</div>\n" +
			"                <div class=\"section-content\">" + (noticeTitle != null ? noticeTitle : "Routine Infrastructure Maintenance") + "</div>\n" +
			"            </div>\n" +
			"            <div class=\"section\">\n" +
			"                <div class=\"section-title\">Operational Impact</div>\n" +
			"                <div class=\"section-content\">" + (details != null ? details.replaceAll("\n", "<br>") : "Service interruptions may occur during this timeframe.") + "</div>\n" +
			"            </div>\n" +
			"        </div>\n" + getFooterContent() +
			"    </div>\n</body>\n</html>";
	}

	private String buildPartnershipMail(String partnerTitle, String partnerEffectiveFrom, String partnerDescription) {
		return "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n" + getCommonStyles() + "</head>\n<body>\n" +
			"    <div class=\"email-container\">\n" +
			"        <div class=\"header\">\n" +
			"            <h1>Network Expansion Update</h1>\n" +
			"            <p>Strategic Partnership Announcement</p>\n" +
			"        </div>\n" +
			"        <div class=\"content\">\n" +
			"            <p style=\"font-size: 16px; margin-bottom: 20px;\">Dear Stakeholder,</p>\n" +
			"            <p style=\"font-size: 14px; line-height: 1.6; margin-bottom: 20px;\">We are pleased to announce an expansion of the NexVitals healthcare and emergency ecosystem.</p>\n" +
			"            <div class=\"section\">\n" +
			"                <span class=\"badge\">New Partnership Integration</span>\n" +
			"                <div class=\"section-title\">Partner Organization</div>\n" +
			"                <div class=\"section-content\">" + (partnerTitle != null ? partnerTitle : "Strategic Partner") + "</div>\n" +
			"            </div>\n" +
			"            <div class=\"section\">\n" +
			"                <div class=\"section-title\">Integration Date</div>\n" +
			"                <div class=\"section-content\">" + (partnerEffectiveFrom != null ? partnerEffectiveFrom : "Forthcoming") + "</div>\n" +
			"            </div>\n" +
			"            <div class=\"section\">\n" +
			"                <div class=\"section-title\">Partnership Details</div>\n" +
			"                <div class=\"highlight-box\">" + (partnerDescription != null ? partnerDescription.replaceAll("\n", "<br>") : "This collaboration strengthens our emergency response chain.") + "</div>\n" +
			"            </div>\n" +
			"        </div>\n" + getFooterContent() +
			"    </div>\n</body>\n</html>";
	}

	private String buildPolicyComplianceMail(String policyTitle, String policyEffectiveDate, String policyDescription) {
		return "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n" + getCommonStyles() + "</head>\n<body>\n" +
			"    <div class=\"email-container\">\n" +
			"        <div class=\"header\">\n" +
			"            <h1>Compliance Notification</h1>\n" +
			"            <p>Policy Framework Update</p>\n" +
			"        </div>\n" +
			"        <div class=\"content\">\n" +
			"            <p style=\"font-size: 16px; margin-bottom: 20px;\">Dear Stakeholder,</p>\n" +
			"            <p style=\"font-size: 14px; line-height: 1.6; margin-bottom: 20px;\">Please review the latest updates regarding our compliance and policy framework.</p>\n" +
			"            <div class=\"section\">\n" +
			"                <span class=\"badge\">Regulatory Update</span>\n" +
			"                <div class=\"section-title\">Policy Designation</div>\n" +
			"                <div class=\"section-content\">" + (policyTitle != null ? policyTitle : "Policy Framework Revision") + "</div>\n" +
			"            </div>\n" +
			"            <div class=\"section\">\n" +
			"                <div class=\"section-title\">Enforcement Date</div>\n" +
			"                <div class=\"section-content\">" + (policyEffectiveDate != null ? policyEffectiveDate : "Effective Immediately") + "</div>\n" +
			"            </div>\n" +
			"            <div class=\"section\">\n" +
			"                <div class=\"section-title\">Framework Adjustments</div>\n" +
			"                <div class=\"highlight-box\">" + (policyDescription != null ? policyDescription.replaceAll("\n", "<br>") : "Please ensure operational alignment with these terms.") + "</div>\n" +
			"            </div>\n" +
			"        </div>\n" + getFooterContent() +
			"    </div>\n</body>\n</html>";
	}

	private String buildTeamAnnouncementMail(String achievementTitle, String teamDescription) {
		return "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n" + getCommonStyles() + "</head>\n<body>\n" +
			"    <div class=\"email-container\">\n" +
			"        <div class=\"header\">\n" +
			"            <h1>Internal Briefing</h1>\n" +
			"            <p>NexVitals Organizational Update</p>\n" +
			"        </div>\n" +
			"        <div class=\"content\">\n" +
			"            <p style=\"font-size: 16px; margin-bottom: 20px;\">Dear Stakeholder,</p>\n" +
			"            <p style=\"font-size: 14px; line-height: 1.6; margin-bottom: 20px;\">We wish to share a recent organizational milestone achieved by the NexVitals team.</p>\n" +
			"            <div class=\"section\">\n" +
			"                <div class=\"highlight-box\" style=\"border-left-color: #4C84D0; background-color: #B2DAE4; color: #4C84D0; font-style: normal; font-weight: bold;\">\n" +
			"                    " + (achievementTitle != null ? achievementTitle : "Organizational Milestone") + "\n" +
			"                </div>\n" +
			"            </div>\n" +
			"            <div class=\"section\">\n" +
			"                <div class=\"section-title\">Briefing Details</div>\n" +
			"                <div class=\"section-content\">" + (teamDescription != null ? teamDescription.replaceAll("\n", "<br>") : "Thank you for your ongoing partnership as we scale our solutions.") + "</div>\n" +
			"            </div>\n" +
			"        </div>\n" + getFooterContent() +
			"    </div>\n</body>\n</html>";
	}

	private String buildGenericUpdateMail(String updateTitle, String updateDescription) {
		return "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n" + getCommonStyles() + "</head>\n<body>\n" +
			"    <div class=\"email-container\">\n" +
			"        <div class=\"header\">\n" +
			"            <h1>System Notification</h1>\n" +
			"            <p>NexVitals General Update</p>\n" +
			"        </div>\n" +
			"        <div class=\"content\">\n" +
			"            <p style=\"font-size: 16px; margin-bottom: 20px;\">Dear Stakeholder,</p>\n" +
			"            <p style=\"font-size: 14px; line-height: 1.6; margin-bottom: 20px;\">Please review the following general advisory from NexVitals.</p>\n" +
			"            <div class=\"section\">\n" +
			"                <div class=\"section-title\">Notification Subject</div>\n" +
			"                <div class=\"section-content\">" + (updateTitle != null ? updateTitle : "General Advisory") + "</div>\n" +
			"            </div>\n" +
			"            <div class=\"section\">\n" +
			"                <div class=\"section-title\">Advisory Details</div>\n" +
			"                <div class=\"highlight-box\">" + (updateDescription != null ? updateDescription.replaceAll("\n", "<br>") : "Please remain advised of this standard communication.") + "</div>\n" +
			"            </div>\n" +
			"        </div>\n" + getFooterContent() +
			"    </div>\n</body>\n</html>";
	}
}