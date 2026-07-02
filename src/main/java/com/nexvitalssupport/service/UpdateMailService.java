package com.nexvitalssupport.service;

import com.nexvitalssupport.mail.MailDispatcher;
import com.nexvitalssupport.model.Update;
import com.nexvitalssupport.model.Subscriber;
import com.nexvitalssupport.repository.UpdateRepository;
import com.nexvitalssupport.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class UpdateMailService {

    @Autowired
    private UpdateRepository updateRepository;
    @Autowired
    private SubscriberRepository subscriberRepository;
    @Autowired
    private MailDispatcher mailDispatcher;

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    // This is the method your AdminService is calling
    public void notifySubscribersOfUpdate(Update update) {
        sendLatestUpdateToAllSubscribers(update.getUpdateId());
    }

    public void sendLatestUpdateToAllSubscribers(Long updateId) {
        Update update = updateRepository.findById(updateId)
            .orElseThrow(() -> new RuntimeException("Update not found"));

        List<Subscriber> subscribers = subscriberRepository.findAll();
        if (subscribers.isEmpty()) return;

        for (Subscriber subscriber : subscribers) {
            executorService.submit(() -> {
                try {
                    mailDispatcher.sendUpdateNotificationMail(subscriber.getEmailId(), update);
                } catch (Exception e) {
                    System.err.println("❌ Failed: " + e.getMessage());
                }
            });
        }
    }

    @PreDestroy
    public void shutdown() {
        executorService.shutdown();
    }
}