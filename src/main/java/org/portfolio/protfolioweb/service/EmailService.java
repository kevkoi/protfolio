package org.portfolio.protfolioweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Value("${portfolio.email.to}")
    private String toEmail;

    public void sendContactEmail(Map<String, String> contactData) {
        String name = contactData.getOrDefault("name", "Anonymous");
        String email = contactData.getOrDefault("email", "No email provided");
        String message = contactData.getOrDefault("message", "No message");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromEmail);
        mailMessage.setTo(toEmail);
        mailMessage.setSubject("New Contact Message from " + name);
        
        String content = String.format(
            "You have received a new message from your portfolio website:\n\n" +
            "Name: %s\n" +
            "Email: %s\n" +
            "Message:\n%s",
            name,
            email,
            message
        );
        
        mailMessage.setText(content);
        mailSender.send(mailMessage);
    }
}
