package com.nexvitalssupport.mail;

import com.nexvitalssupport.mail.template.*;
import com.nexvitalssupport.model.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.time.format.DateTimeFormatter;

@Component
public class MailDispatcher {

	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String fromEmail;

	// Injecting all mail templates
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

	/**
	 * Helper method to send HTML emails
	 */
	private void sendHtmlMail(String to, String subject, String htmlContent) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

			helper.setFrom(fromEmail);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(htmlContent, true);

			mailSender.send(message);
			System.out.println("✅ HTML Email sent to: " + to);
		} catch (MessagingException e) {
			System.err.println("❌ Error sending HTML email: " + e.getMessage());
			throw new RuntimeException("Failed to send email", e);
		}
	}

	/**
	 * Send password reset email
	 */
	public void sendPasswordResetMail(String to, String resetLink) {
		String subject = "🔐 Password Reset - NexVitals Support";
		String htmlContent = adminPasswordMailTemplate.buildResetLinkMail(resetLink);
		sendHtmlMail(to, subject, htmlContent);
	}

	/**
	 * Send update notification email to subscriber
	 * This method is called when a new update is posted to the Updates table
	 */
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
			
			sendHtmlMail(subscriberEmail, subject, htmlContent);
		} catch (Exception e) {
			System.err.println("❌ Error sending update notification: " + e.getMessage());
			throw new RuntimeException("Failed to send update notification email", e);
		}
	}

	/**
	 * Helper method to build subject line based on update category and title
	 */
	private String buildSubjectFromUpdate(Update update) {
		String category = update.getCategory().toLowerCase();
		String title = update.getUpdateTitle() != null ? update.getUpdateTitle() : "Update";
		
		switch(category) {
			case "product-updates":
				return "🚀 Product Update: " + title;
			case "workflow-announcements":
				return "📢 Workflow Announcement: " + (update.getProtocolUpdate() != null ? update.getProtocolUpdate() : "Update");
			case "maintenance-notices":
				return "⚠️ Maintenance Notice: " + (update.getNoticeTitle() != null ? update.getNoticeTitle() : "Scheduled Maintenance");
			case "partnership-network-expansion":
				return "🤝 Partnership: " + (update.getPartnerTitle() != null ? update.getPartnerTitle() : "New Partnership");
			case "policy-compliance":
				return "📜 Policy Update: " + (update.getPolicyTitle() != null ? update.getPolicyTitle() : "Policy Change");
			case "internal-team-announcements":
				return "🎉 Team Announcement: " + (update.getAchievementTitle() != null ? update.getAchievementTitle() : "Team Update");
			default:
				return "📰 Update: " + title;
		}
	}

	/**
	 * Send welcome email to new subscribers
	 */
	public void sendSubscriberWelcomeMail(String emailId) {
		String subject = "Welcome to NexVitals Support!";
		String htmlContent = subscriberMailTemplate.buildWelcomeMail(emailId);
		sendHtmlMail(emailId, subject, htmlContent);
	}

	/**
	 * Send acknowledgment for submitted grievances
	 */
	public void sendGrievanceAckMail(String emailId, String grievanceCatagory) {
		String subject = "NexVitals Support - Acknowledgment of Receipt";
		String htmlContent = grievanceMailTemplate.buildAckMail(emailId, grievanceCatagory);
		sendHtmlMail(emailId, subject, htmlContent);
	}

	/**
	 * Send acknowledgment for submitted suggestions
	 */
	public void sendSuggestionAckMail(String emailId, String name) {
		String subject = "NexVitals Support - Thank You for Your Suggestion";
		String htmlContent = suggestionMailTemplate.buildAckMail(name);
		sendHtmlMail(emailId, subject, htmlContent);
	}

	/**
	 * Send acknowledgment for submitted reviews
	 */
	public void sendReviewAckMail(String emailId, String name) {
		String subject = "NexVitals Support - Thank You for Your Review";
		String htmlContent = reviewMailTemplate.buildAckMail(name);
		sendHtmlMail(emailId, subject, htmlContent);
	}

	/**
	 * Send basic plain text email (Retained for legacy/utility purposes)
	 */
	public void sendSimpleMail(String to, String subject, String body) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(fromEmail);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(body);
			mailSender.send(message);

			System.out.println("✅ Plain text email sent to: " + to);
		} catch (Exception e) {
			System.err.println("❌ Error sending email: " + e.getMessage());
		}
	}
}