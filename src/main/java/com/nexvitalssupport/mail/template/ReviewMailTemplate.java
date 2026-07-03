package com.nexvitalssupport.mail.template;

import org.springframework.stereotype.Component;

@Component
public class ReviewMailTemplate {

	public String buildAckMail(String name) {
		return "<div style=\"font-family: 'Noto Serif', serif; font-style: italic; font-weight: 300; max-width: 600px; margin: auto; padding: 30px; background-color: #fcfcfc; border: 1px solid #CCBEB1; border-radius: 8px; color: #4C84D0;\">"
				+ "<div style=\"text-align: center; border-bottom: 2px solid #B2DAE4; padding-bottom: 15px; margin-bottom: 20px;\">"
				+ "<h2 style=\"color: #4C84D0; margin: 0; font-size: 24px;\">Thank You for Your Review</h2>"
				+ "</div>"
				+ "<p style=\"font-size: 16px; line-height: 1.6; color: #333333;\">Dear " + name + ",</p>"
				+ "<p style=\"font-size: 16px; line-height: 1.6; color: #333333;\">Thank you for taking the time to share your experience with NexVitals.</p>"
				+ "<p style=\"font-size: 16px; line-height: 1.6; color: #333333;\">Honest feedback from real users helps families choose smarter protection and pushes us to raise the standard of emergency care. Your insights are invaluable to our continuous improvement.</p>"
				+ "<p style=\"font-size: 16px; line-height: 1.6; color: #333333; margin-top: 30px;\">Sincerely,<br>Team NexVitals</p>"
				+ "<div style=\"margin-top: 40px; padding-top: 20px; border-top: 1px solid #D8D4BC; text-align: center; font-size: 12px; color: #ACC0D3;\">"
				+ "<p><em>From Road to Recovery — Powered by NexVitals.</em></p>"
				+ "<p>Contact Support: nexvitalssupport@gmail.com</p>"
				+ "</div>"
				+ "</div>";
	}
}