package com.portfolio.portfoliokevincastillo.services;

import com.portfolio.portfoliokevincastillo.entities.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Value("#{getEmailReceiver}")
    private String emailReceiver;
    @Value("#{getEmailSender}")
    private String emailSender;

    public void emailSent(EmailMessage emailMessage) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailReceiver);
        message.setSubject(emailMessage.getSubject());
        message.setText(emailMessage.getBody());
        message.setFrom(emailSender);
        mailSender.send(message);
    }
}
