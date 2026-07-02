package com.nexvitalssupport.mail.template;

import org.springframework.stereotype.Component;

@Component
public class GrievanceMailTemplate {

	public String buildAckMail(String toEmail, String grievanceCategory) {
		// toEmail parameter is maintained in the signature to preserve fields, but omitted from the output.
		return "<div style=\"font-family: 'Noto Serif', serif; font-style: italic; font-weight: 300; max-width: 600px; margin: auto; padding: 30px; background-color: #fcfcfc; border: 1px solid #CCBEB1; border-radius: 8px; color: #4C84D0;\">"
				+ "<div style=\"text-align: center; border-bottom: 2px solid #B2DAE4; padding-bottom: 15px; margin-bottom: 20px;\">"
				+ "<h2 style=\"color: #4C84D0; margin: 0; font-size: 24px;\">Grievance Acknowledgement</h2>"
				+ "</div>"
				+ "<p style=\"font-size: 16px; line-height: 1.6; color: #333333;\">Hello,</p>"
				+ "<p style=\"font-size: 16px; line-height: 1.6; color: #333333;\">This email confirms that we have successfully received your formal grievance submission under the category: <strong style=\"color: #4C84D0;\">" + grievanceCategory + "</strong>.</p>"
				+ "<p style=\"font-size: 16px; line-height: 1.6; color: #333333;\">Our quality assurance team is currently reviewing your submission. We are committed to responding within 48 business hours. If your complaint relates to a missed emergency response, it has been escalated to our Crisis Response Team for immediate investigation.</p>"
				+ "<p style=\"font-size: 16px; line-height: 1.6; color: #333333;\">We appreciate your patience and your commitment to helping us improve our systems.</p>"
				+ "<p style=\"font-size: 16px; line-height: 1.6; color: #333333; margin-top: 30px;\">Sincerely,<br>Team NexVitals Support</p>"
				+ "<div style=\"margin-top: 40px; padding-top: 20px; border-top: 1px solid #D8D4BC; text-align: center; font-size: 12px; color: #ACC0D3;\">"
				+ "<p><em>Every Second Counts. We Make Sure It Does.</em></p>"
				+ "Contact Support: nexvitalssupport@gmail.com</p>"
				+ "</div>"
				+ "</div>";
	}
}