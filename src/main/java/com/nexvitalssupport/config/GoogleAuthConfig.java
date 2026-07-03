package com.nexvitalssupport.config;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.UserCredentials;
import com.google.api.services.gmail.Gmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Configuration
public class GoogleAuthConfig {

    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    @Value("${google.oauth2.client-id}")
    private String clientId;

    @Value("${google.oauth2.client-secret}")
    private String clientSecret;

    @Value("${google.oauth2.refresh-token}")
    private String refreshToken;

    @Value("${gmail.sender-email}")
    private String senderEmail;

    @Bean
    public Gmail gmail() throws GeneralSecurityException, IOException {
        
        // Build the credentials using the OAuth2 Refresh Token
        UserCredentials credentials = UserCredentials.newBuilder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setRefreshToken(refreshToken)
                .build();
                
        // Wrap the credentials for the HTTP request adapter
        HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(credentials);

        // Build and return the authorized Gmail client
        return new Gmail.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                requestInitializer)
                .setApplicationName("NexVitals Support")
                .build();
    }
}