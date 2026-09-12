package com.cutomersupport.mail.template;

import org.springframework.stereotype.Component;

@Component
public class SendSubsUpdateMailTemplate {

    public String buildUpdateNotificationMail(
            String updateCategory,
            String updateTitle,
            String updateDescription,
            String versionNumber,
            String whatChanged,
            String whoItAffects,
            String workflowUpdate,
            String effectiveFromDate,
            String implementationDate,
            String noticeTitle,
            String startDateTime,
            String endDateTime,
            String details,
            String featureTitle,
            String featureReleaseDate,
            String featureDescription,
            String policyTitle,
            String policyEffectiveDate,
            String policyDescription,
            String achievementTitle,
            String teamDescription) {

        String htmlContent;

        if (updateCategory == null || updateCategory.isEmpty()) {
            htmlContent = buildGenericUpdateMail(
                    updateTitle,
                    updateDescription
            );
        } else {

            switch (updateCategory.toLowerCase()) {

                case "product-updates":
                    htmlContent = buildProductUpdateMail(
                            updateTitle,
                            versionNumber,
                            whatChanged,
                            whoItAffects
                    );
                    break;

                case "workflow-updates":
                    htmlContent = buildWorkflowUpdateMail(
                            workflowUpdate,
                            effectiveFromDate,
                            updateDescription,
                            implementationDate
                    );
                    break;

                case "maintenance-notices":
                    htmlContent = buildMaintenanceNoticeMail(
                            noticeTitle,
                            startDateTime,
                            endDateTime,
                            details
                    );
                    break;

                case "feature-releases":
                    htmlContent = buildFeatureReleaseMail(
                            featureTitle,
                            featureReleaseDate,
                            featureDescription
                    );
                    break;

                case "policy-updates":
                    htmlContent = buildPolicyUpdateMail(
                            policyTitle,
                            policyEffectiveDate,
                            policyDescription
                    );
                    break;

                case "team-announcements":
                    htmlContent = buildTeamAnnouncementMail(
                            achievementTitle,
                            teamDescription
                    );
                    break;

                default:
                    htmlContent = buildGenericUpdateMail(
                            updateTitle,
                            updateDescription
                    );
                    break;
            }
        }

        return htmlContent;
    }


    private String getCommonStyles() {

        return "    <style>\n" +
                "        * { margin: 0; padding: 0; }\n" +
                "        body { font-family: Arial, sans-serif; background-color: #f5f5f5; color: #333333; }\n" +
                "        .email-container { max-width: 600px; margin: 20px auto; background-color: #ffffff; border: 1px solid #CCBEB1; border-radius: 8px; overflow: hidden; }\n" +
                "        .header { background-color: #4C84D0; color: white; padding: 30px 20px; text-align: center; border-bottom: 4px solid #B2DAE4; }\n" +
                "        .header h1 { font-size: 24px; font-weight: normal; margin-bottom: 5px; }\n" +
                "        .header p { font-size: 14px; opacity: 0.9; }\n" +
                "        .content { padding: 30px 20px; }\n" +
                "        .section { margin-bottom: 25px; }\n" +
                "        .section-title { font-size: 14px; font-weight: bold; color: #4C84D0; margin-bottom: 10px; text-transform: uppercase; letter-spacing: 1px; }\n" +
                "        .section-content { font-size: 14px; color: #333333; line-height: 1.6; }\n" +
                "        .badge { display: inline-block; background-color: #B2DAE4; color: #4C84D0; padding: 6px 12px; border-radius: 4px; font-size: 12px; font-weight: bold; margin-bottom: 15px; }\n" +
                "        .highlight-box { background-color: #fcfcfc; border-left: 4px solid #D8D4BC; padding: 15px; margin-bottom: 15px; }\n" +
                "        .footer { background-color: #f9f9f9; padding: 20px; text-align: center; font-size: 12px; color: #ACC0D3; border-top: 1px solid #CCBEB1; }\n" +
                "        .footer a { color: #4C84D0; text-decoration: none; }\n" +
                "    </style>\n";
    }


    private String getFooterContent() {

        return "        <div class=\"footer\">\n" +
                "            <p><em>Wavepoint — WORK SMART. STAY ON COURSE.</em></p>\n" +
                "            <p>Contact: support@wavepoint.com</p>\n" +
                "        </div>\n";
    }


    private String buildProductUpdateMail(
            String updateTitle,
            String versionNumber,
            String whatChanged,
            String whoItAffects) {

        return "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n" +
                getCommonStyles() +
                "</head>\n<body>\n" +

                "    <div class=\"email-container\">\n" +

                "        <div class=\"header\">\n" +
                "            <h1>Product Update</h1>\n" +
                "            <p>Wavepoint Product Update</p>\n" +
                "        </div>\n" +

                "        <div class=\"content\">\n" +

                "            <p style=\"font-size: 16px; margin-bottom: 20px;\">Hello,</p>\n" +

                "            <p style=\"font-size: 14px; line-height: 1.6; margin-bottom: 20px;\">" +
                "We are pleased to share the latest product update from Wavepoint." +
                "</p>\n" +

                "            <div class=\"section\">\n" +
                "                <span class=\"badge\">Version " +
                (versionNumber != null ? versionNumber : "Latest") +
                "</span>\n" +

                "                <div class=\"section-title\">Update Title</div>\n" +
                "                <div class=\"section-content\">" +
                (updateTitle != null ? updateTitle : "Product Update") +
                "</div>\n" +
                "            </div>\n" +

                "            <div class=\"section\">\n" +
                "                <div class=\"section-title\">What Changed</div>\n" +
                "                <div class=\"highlight-box\">" +
                (whatChanged != null
                        ? whatChanged.replaceAll("\n", "<br>")
                        : "Product improvements have been introduced.") +
                "</div>\n" +
                "            </div>\n" +

                "            <div class=\"section\">\n" +
                "                <div class=\"section-title\">Who It Affects</div>\n" +
                "                <div class=\"section-content\">" +
                (whoItAffects != null
                        ? whoItAffects.replaceAll("\n", "<br>")
                        : "Please review the update details for impact information.") +
                "</div>\n" +
                "            </div>\n" +

                "        </div>\n" +
                getFooterContent() +

                "    </div>\n</body>\n</html>";
    }


    private String buildWorkflowUpdateMail(
            String workflowUpdate,
            String effectiveFromDate,
            String updateDescription,
            String implementationDate) {

        return "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n" +
                getCommonStyles() +
                "</head>\n<body>\n" +

                "    <div class=\"email-container\">\n" +

                "        <div class=\"header\">\n" +
                "            <h1>Workflow Update</h1>\n" +
                "            <p>Wavepoint Workflow Improvements</p>\n" +
                "        </div>\n" +

                "        <div class=\"content\">\n" +

                "            <p style=\"font-size: 16px; margin-bottom: 20px;\">Hello,</p>\n" +

                "            <p style=\"font-size: 14px; line-height: 1.6; margin-bottom: 20px;\">" +
                "A workflow update has been announced for Wavepoint." +
                "</p>\n" +

                "            <div class=\"section\">\n" +
                "                <div class=\"section-title\">Workflow Update</div>\n" +
                "                <div class=\"section-content\">" +
                (workflowUpdate != null
                        ? workflowUpdate
                        : "Workflow improvements have been introduced.") +
                "</div>\n" +
                "            </div>\n" +

                "            <div class=\"section\">\n" +
                "                <span class=\"badge\">Effective From: " +
                (effectiveFromDate != null ? effectiveFromDate : "Immediately") +
                "</span>\n" +

                "                <div class=\"section-title\">Update Description</div>\n" +
                "                <div class=\"highlight-box\">" +
                (updateDescription != null
                        ? updateDescription.replaceAll("\n", "<br>")
                        : "Please review the workflow update details.") +
                "</div>\n" +
                "            </div>\n" +

                "            <div class=\"section\">\n" +
                "                <div class=\"section-title\">Implementation Date</div>\n" +
                "                <div class=\"section-content\">" +
                (implementationDate != null
                        ? implementationDate
                        : "To be announced") +
                "</div>\n" +
                "            </div>\n" +

                "        </div>\n" +
                getFooterContent() +

                "    </div>\n</body>\n</html>";
    }


    private String buildMaintenanceNoticeMail(
            String noticeTitle,
            String startDateTime,
            String endDateTime,
            String details) {

        return "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n" +
                getCommonStyles() +
                "</head>\n<body>\n" +

                "    <div class=\"email-container\">\n" +

                "        <div class=\"header\">\n" +
                "            <h1>Maintenance Notice</h1>\n" +
                "            <p>Wavepoint Service Maintenance</p>\n" +
                "        </div>\n" +

                "        <div class=\"content\">\n" +

                "            <p style=\"font-size: 16px; margin-bottom: 20px;\">Hello,</p>\n" +

                "            <p style=\"font-size: 14px; line-height: 1.6; margin-bottom: 20px;\">" +
                "Wavepoint has scheduled maintenance that may temporarily affect platform availability." +
                "</p>\n" +

                "            <div class=\"section\">\n" +
                "                <div class=\"section-title\">Maintenance Window</div>\n" +

                "                <div class=\"highlight-box\">\n" +
                "                    <strong>Start:</strong> " +
                (startDateTime != null ? startDateTime : "Pending schedule") +
                "<br>\n" +

                "                    <strong>End:</strong> " +
                (endDateTime != null ? endDateTime : "Pending schedule") +
                "\n" +
                "                </div>\n" +
                "            </div>\n" +

                "            <div class=\"section\">\n" +
                "                <div class=\"section-title\">Notice</div>\n" +
                "                <div class=\"section-content\">" +
                (noticeTitle != null
                        ? noticeTitle
                        : "Scheduled Wavepoint Maintenance") +
                "</div>\n" +
                "            </div>\n" +

                "            <div class=\"section\">\n" +
                "                <div class=\"section-title\">Details</div>\n" +
                "                <div class=\"section-content\">" +
                (details != null
                        ? details.replaceAll("\n", "<br>")
                        : "Please review the maintenance information.") +
                "</div>\n" +
                "            </div>\n" +

                "        </div>\n" +
                getFooterContent() +

                "    </div>\n</body>\n</html>";
    }


    private String buildFeatureReleaseMail(
            String featureTitle,
            String featureReleaseDate,
            String featureDescription) {

        return "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n" +
                getCommonStyles() +
                "</head>\n<body>\n" +

                "    <div class=\"email-container\">\n" +

                "        <div class=\"header\">\n" +
                "            <h1>Feature Release</h1>\n" +
                "            <p>New Wavepoint Capability</p>\n" +
                "        </div>\n" +

                "        <div class=\"content\">\n" +

                "            <p style=\"font-size: 16px; margin-bottom: 20px;\">Hello,</p>\n" +

                "            <p style=\"font-size: 14px; line-height: 1.6; margin-bottom: 20px;\">" +
                "A new feature is now available in Wavepoint." +
                "</p>\n" +

                "            <div class=\"section\">\n" +
                "                <div class=\"section-title\">Feature</div>\n" +
                "                <div class=\"section-content\">" +
                (featureTitle != null
                        ? featureTitle
                        : "New Wavepoint Feature") +
                "</div>\n" +
                "            </div>\n" +

                "            <div class=\"section\">\n" +
                "                <span class=\"badge\">Release Date: " +
                (featureReleaseDate != null
                        ? featureReleaseDate
                        : "Available Now") +
                "</span>\n" +

                "                <div class=\"section-title\">Feature Description</div>\n" +
                "                <div class=\"highlight-box\">" +
                (featureDescription != null
                        ? featureDescription.replaceAll("\n", "<br>")
                        : "Please review the latest Wavepoint feature.") +
                "</div>\n" +
                "            </div>\n" +

                "        </div>\n" +
                getFooterContent() +

                "    </div>\n</body>\n</html>";
    }


    private String buildPolicyUpdateMail(
            String policyTitle,
            String policyEffectiveDate,
            String policyDescription) {

        return "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n" +
                getCommonStyles() +
                "</head>\n<body>\n" +

                "    <div class=\"email-container\">\n" +

                "        <div class=\"header\">\n" +
                "            <h1>Policy Update</h1>\n" +
                "            <p>Wavepoint Policy Information</p>\n" +
                "        </div>\n" +

                "        <div class=\"content\">\n" +

                "            <p style=\"font-size: 16px; margin-bottom: 20px;\">Hello,</p>\n" +

                "            <p style=\"font-size: 14px; line-height: 1.6; margin-bottom: 20px;\">" +
                "Please review the latest Wavepoint policy update." +
                "</p>\n" +

                "            <div class=\"section\">\n" +
                "                <div class=\"section-title\">Policy</div>\n" +
                "                <div class=\"section-content\">" +
                (policyTitle != null
                        ? policyTitle
                        : "Wavepoint Policy Update") +
                "</div>\n" +
                "            </div>\n" +

                "            <div class=\"section\">\n" +
                "                <div class=\"section-title\">Effective Date</div>\n" +
                "                <div class=\"section-content\">" +
                (policyEffectiveDate != null
                        ? policyEffectiveDate
                        : "Effective Immediately") +
                "</div>\n" +
                "            </div>\n" +

                "            <div class=\"section\">\n" +
                "                <div class=\"section-title\">Description</div>\n" +
                "                <div class=\"highlight-box\">" +
                (policyDescription != null
                        ? policyDescription.replaceAll("\n", "<br>")
                        : "Please review the policy details.") +
                "</div>\n" +
                "            </div>\n" +

                "        </div>\n" +
                getFooterContent() +

                "    </div>\n</body>\n</html>";
    }


    private String buildTeamAnnouncementMail(
            String achievementTitle,
            String teamDescription) {

        return "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n" +
                getCommonStyles() +
                "</head>\n<body>\n" +

                "    <div class=\"email-container\">\n" +

                "        <div class=\"header\">\n" +
                "            <h1>Team Announcement</h1>\n" +
                "            <p>Wavepoint Team News</p>\n" +
                "        </div>\n" +

                "        <div class=\"content\">\n" +

                "            <p style=\"font-size: 16px; margin-bottom: 20px;\">Hello,</p>\n" +

                "            <p style=\"font-size: 14px; line-height: 1.6; margin-bottom: 20px;\">" +
                "Here is the latest announcement from the Wavepoint team." +
                "</p>\n" +

                "            <div class=\"section\">\n" +
                "                <div class=\"highlight-box\" style=\"border-left-color: #4C84D0; background-color: #B2DAE4; color: #4C84D0; font-weight: bold;\">\n" +
                (achievementTitle != null
                        ? achievementTitle
                        : "Wavepoint Team Announcement") +
                "\n" +
                "                </div>\n" +
                "            </div>\n" +

                "            <div class=\"section\">\n" +
                "                <div class=\"section-title\">Announcement Details</div>\n" +
                "                <div class=\"section-content\">" +
                (teamDescription != null
                        ? teamDescription.replaceAll("\n", "<br>")
                        : "Thank you for being part of the Wavepoint community.") +
                "</div>\n" +
                "            </div>\n" +

                "        </div>\n" +
                getFooterContent() +

                "    </div>\n</body>\n</html>";
    }


    private String buildGenericUpdateMail(
            String updateTitle,
            String updateDescription) {

        return "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n" +
                getCommonStyles() +
                "</head>\n<body>\n" +

                "    <div class=\"email-container\">\n" +

                "        <div class=\"header\">\n" +
                "            <h1>Wavepoint Update</h1>\n" +
                "            <p>Product Information</p>\n" +
                "        </div>\n" +

                "        <div class=\"content\">\n" +

                "            <p style=\"font-size: 16px; margin-bottom: 20px;\">Hello,</p>\n" +

                "            <p style=\"font-size: 14px; line-height: 1.6; margin-bottom: 20px;\">" +
                "Please review the following update from Wavepoint." +
                "</p>\n" +

                "            <div class=\"section\">\n" +
                "                <div class=\"section-title\">Update</div>\n" +
                "                <div class=\"section-content\">" +
                (updateTitle != null
                        ? updateTitle
                        : "Wavepoint Update") +
                "</div>\n" +
                "            </div>\n" +

                "            <div class=\"section\">\n" +
                "                <div class=\"section-title\">Details</div>\n" +
                "                <div class=\"highlight-box\">" +
                (updateDescription != null
                        ? updateDescription.replaceAll("\n", "<br>")
                        : "Please review the update information.") +
                "</div>\n" +
                "            </div>\n" +

                "        </div>\n" +
                getFooterContent() +

                "    </div>\n</body>\n</html>";
    }
}