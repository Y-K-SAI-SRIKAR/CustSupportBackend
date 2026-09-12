package com.cutomersupport.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cutomersupport.model.Update;

@Service
public class MailService {

    @Autowired
    private MailDispatcher mailDispatcher;

    public void sendPasswordResetEmail(String email, String resetLink) {
        mailDispatcher.sendPasswordResetMail(email, resetLink);
    }

    public void sendWelcomeEmail(String email) {
        mailDispatcher.sendSubscriberWelcomeMail(email);
    }

    public void sendUpdateNotification(String subscriberEmail, Update update) {
        mailDispatcher.sendUpdateNotificationMail(subscriberEmail, update);
    }

    public void sendGrievanceAck(String email, String category) {
        mailDispatcher.sendGrievanceAckMail(email, category);
    }

    public void sendReviewAck(String email, String name) {
        mailDispatcher.sendReviewAckMail(email, name);
    }

    public void sendSuggestionAck(String email, String name) {
        mailDispatcher.sendSuggestionAckMail(email, name);
    }
}