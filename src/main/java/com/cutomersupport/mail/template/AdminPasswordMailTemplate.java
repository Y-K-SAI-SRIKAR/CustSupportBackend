package com.cutomersupport.mail.template;

import org.springframework.stereotype.Component;

@Component
public class AdminPasswordMailTemplate {

    public String buildResetLinkMail(String resetLink) {

        return "<div style=\"font-family: 'Noto Serif', serif; font-style: italic; font-weight: 300; max-width: 600px; margin: auto; padding: 30px; background-color: #fcfcfc; border: 1px solid #CCBEB1; border-radius: 8px; color: #4C84D0;\">"

                + "<div style=\"text-align: center; border-bottom: 2px solid #B2DAE4; padding-bottom: 15px; margin-bottom: 20px;\">"

                + "<h2 style=\"color: #4C84D0; margin: 0; font-size: 24px;\">Password Reset Request</h2>"

                + "</div>"

                + "<p style=\"font-size: 16px; line-height: 1.6; color: #333333;\">Dear Admin,</p>"

                + "<p style=\"font-size: 16px; line-height: 1.6; color: #333333;\">We received a secure request to reset the password for your Wavepoint administrative account.</p>"

                + "<p style=\"font-size: 16px; line-height: 1.6; color: #333333;\">Please click the button below to establish a new password. For security purposes, this authorization link will expire in <b>30 minutes</b>.</p>"

                + "<div style=\"text-align: center; margin: 30px 0;\">"

                + "<a href='" + resetLink + "' style=\"background-color: #4C84D0; color: #ffffff; padding: 14px 28px; text-decoration: none; border-radius: 4px; display: inline-block; font-weight: bold; font-style: normal;\">Reset Password</a>"

                + "</div>"

                + "<p style=\"font-size: 14px; line-height: 1.6; color: #666666;\">If you did not initiate this request, please disregard this communication. Your account remains secure.</p>"

                + "<p style=\"font-size: 16px; line-height: 1.6; color: #333333; margin-top: 30px;\">Sincerely,<br>The Wavepoint Security Team</p>"

                + "<div style=\"margin-top: 40px; padding-top: 20px; border-top: 1px solid #D8D4BC; text-align: center; font-size: 12px; color: #ACC0D3;\">"

                + "<p><em>Wavepoint — WORK SMART. STAY ON COURSE.</em></p>"

                + "<p>Contact Support: support@wavepoint.com</p>"

                + "</div>"

                + "</div>";
    }
}