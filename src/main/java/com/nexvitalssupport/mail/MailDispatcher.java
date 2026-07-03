package com.nexvitalssupport.mail;

import com.google.api.services.gmail.Gmail;
import com.nexvitalssupport.mail.template.*;
import com.nexvitalssupport.model.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Properties;

@Component
public class MailDispatcher {

    @Autowired
    private Gmail gmailService;

    @Value("${gmail.sender-email}")
    private String senderEmail;

    @Autowired
    private AdminPasswordMailTemplate adminPasswordMailTemplate;

    @Autowired
    private GrievanceMailTemplate grievanceMailTemplate;

    @Autowired
    private ReviewMailTemplate reviewMailTemplate;

    @Autowired
    private SubscriberMailTemplate subscriberMailTemplate;

    @Autowired
    private SuggestionMailTemplate suggestionMailTemplate;

    @Autowired
    private SendSubsUpdateMailTemplate sendSubsUpdateMailTemplate;

    private void sendEmail(String to, String subject, String htmlContent) {
        try {
            Properties props = new Properties();
            Session session = Session.getInstance(props, null);
            MimeMessage email = new MimeMessage(session);

            email.setFrom(new InternetAddress(senderEmail));
            email.addRecipient(jakarta.mail.Message.RecipientType.TO, new InternetAddress(to));
            email.setSubject(subject);
            email.setContent(htmlContent, "text/html; charset=utf-8");

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            email.writeTo(buffer);
            String encodedEmail = Base64.getUrlEncoder().withoutPadding().encodeToString(buffer.toByteArray());

            com.google.api.services.gmail.model.Message message = new com.google.api.services.gmail.model.Message();
            message.setRaw(encodedEmail);

            gmailService.users().messages().send("me", message).execute();
            System.out.println("✅ Email sent to: " + to);
        } catch (Exception e) {
            System.err.println("❌ Error sending email to " + to + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendPasswordResetMail(String to, String resetLink) {
        try {
            String subject = "🔐 Password Reset - NexVitals Support";
            String htmlContent = adminPasswordMailTemplate.buildResetLinkMail(resetLink);
            sendEmail(to, subject, htmlContent);
        } catch (Exception e) {
            System.err.println("❌ Error in password reset email: " + e.getMessage());
        }
    }

    public void sendUpdateNotificationMail(String subscriberEmail, Update update) {
        try {
            String subject = buildSubjectFromUpdate(update);
            String htmlContent = sendSubsUpdateMailTemplate.buildUpdateNotificationMail(
                update.getCategory(),
                update.getUpdateTitle(),
                update.getUpdateDescription(),
                update.getVersionNumber(),
                update.getWhatChanged(),
                update.getWhoItAffects(),
                update.getProtocolUpdate(),
                update.getEffectiveFrom() != null ? update.getEffectiveFrom().toString() : null,
                update.getNoticeTitle(),
                update.getStartDateTime() != null ? update.getStartDateTime().toString() : null,
                update.getEndDateTime() != null ? update.getEndDateTime().toString() : null,
                update.getDetails(),
                update.getPartnerTitle(),
                update.getPartnerEffectiveFrom() != null ? update.getPartnerEffectiveFrom().toString() : null,
                update.getPartnerDescription(),
                update.getPolicyTitle(),
                update.getPolicyEffectiveDate() != null ? update.getPolicyEffectiveDate().toString() : null,
                update.getPolicyDescription(),
                update.getAchievementTitle(),
                update.getTeamDescription()
            );
            sendEmail(subscriberEmail, subject, htmlContent);
        } catch (Exception e) {
            System.err.println("❌ Error in update notification: " + e.getMessage());
        }
    }

    private String buildSubjectFromUpdate(Update update) {
        if (update == null || update.getCategory() == null) {
            return "📰 NexVitals Update";
        }

        String category = update.getCategory().toLowerCase();
        String title = update.getUpdateTitle() != null ? update.getUpdateTitle() : "Update";

        return switch(category) {
            case "product-updates" -> "🚀 Product Update: " + title;
            case "workflow-announcements" -> "📢 Workflow Announcement";
            case "maintenance-notices" -> "⚠️ Maintenance Notice";
            case "partnership-network-expansion" -> "🤝 Partnership";
            case "policy-compliance" -> "📜 Policy Update";
            case "internal-team-announcements" -> "🎉 Team Announcement";
            default -> "📰 Update";
        };
    }

    public void sendSubscriberWelcomeMail(String emailId) {
        try {
            String subject = "Welcome to NexVitals Support! 🎉";
            String htmlContent = subscriberMailTemplate.buildWelcomeMail(emailId);
            sendEmail(emailId, subject, htmlContent);
        } catch (Exception e) {
            System.err.println("❌ Error in welcome email: " + e.getMessage());
        }
    }

    public void sendGrievanceAckMail(String emailId, String grievanceCatagory) {
        try {
            String subject = "Grievance Received - NexVitals Support";
            String htmlContent = grievanceMailTemplate.buildAckMail(emailId, grievanceCatagory);
            sendEmail(emailId, subject, htmlContent);
        } catch (Exception e) {
            System.err.println("❌ Error in grievance email: " + e.getMessage());
        }
    }

    public void sendSuggestionAckMail(String emailId, String name) {
        try {
            String subject = "Thank You for Your Suggestion!";
            String htmlContent = suggestionMailTemplate.buildAckMail(name);
            sendEmail(emailId, subject, htmlContent);
        } catch (Exception e) {
            System.err.println("❌ Error in suggestion email: " + e.getMessage());
        }
    }

    public void sendReviewAckMail(String emailId, String name) {
        try {
            String subject = "Thank You for Your Review!";
            String htmlContent = reviewMailTemplate.buildAckMail(name);
            sendEmail(emailId, subject, htmlContent);
        } catch (Exception e) {
            System.err.println("❌ Error in review email: " + e.getMessage());
        }
    }

    public void sendSimpleMail(String to, String subject, String body) {
        try {
            Properties props = new Properties();
            Session session = Session.getInstance(props, null);
            MimeMessage email = new MimeMessage(session);

            email.setFrom(new InternetAddress(senderEmail));
            email.addRecipient(jakarta.mail.Message.RecipientType.TO, new InternetAddress(to));
            email.setSubject(subject);
            email.setText(body);

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            email.writeTo(buffer);
            String encodedEmail = Base64.getUrlEncoder().withoutPadding().encodeToString(buffer.toByteArray());

            com.google.api.services.gmail.model.Message message = new com.google.api.services.gmail.model.Message();
            message.setRaw(encodedEmail);

            gmailService.users().messages().send("me", message).execute();
            System.out.println("✅ Plain text email sent to: " + to);
        } catch (Exception e) {
            System.err.println("❌ Error in simple mail: " + e.getMessage());
        }
    }
}