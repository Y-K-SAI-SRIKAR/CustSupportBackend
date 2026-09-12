package com.cutomersupport.mail.template;

import org.springframework.stereotype.Component;

@Component
public class SubscriberMailTemplate {

    public String buildWelcomeMail(String toEmail) {

        // toEmail parameter is maintained in the signature
        // to preserve the existing method contract.

        return "<div style=\"font-family: 'Noto Serif', serif; font-style: italic; font-weight: 300; max-width: 600px; margin: auto; padding: 30px; background-color: #fcfcfc; border: 1px solid #CCBEB1; border-radius: 8px; color: #4C84D0;\">"

                + "<div style=\"text-align: center; border-bottom: 2px solid #B2DAE4; padding-bottom: 15px; margin-bottom: 20px;\">"

                + "<h2 style=\"color: #4C84D0; margin: 0; font-size: 24px;\">Welcome to Wavepoint</h2>"

                + "</div>"

                + "<p style=\"font-size: 16px; line-height: 1.6; color: #333333;\">Hello,</p>"

                + "<p style=\"font-size: 16px; line-height: 1.6; color: #333333;\">Thank you for subscribing to Wavepoint updates.</p>"

                + "<p style=\"font-size: 16px; line-height: 1.6; color: #333333;\">You are now connected to the latest Wavepoint news. You will receive updates about product improvements, workflow enhancements, new features, maintenance notices, policy updates, and announcements directly in your inbox.</p>"

                + "<p style=\"font-size: 16px; line-height: 1.6; color: #333333; margin-top: 30px;\">Sincerely,<br>Team Wavepoint</p>"

                + "<div style=\"margin-top: 40px; padding-top: 20px; border-top: 1px solid #D8D4BC; text-align: center; font-size: 12px; color: #ACC0D3;\">"

                + "<p><em>Wavepoint — WORK SMART. STAY ON COURSE.</em></p>"

                + "<p>Contact Support: support@wavepoint.com</p>"

                + "</div>"

                + "</div>";
    }
}