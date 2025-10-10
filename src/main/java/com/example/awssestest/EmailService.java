package com.example.awssestest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class EmailService {
	
	private final MailSender mailSender;

    @Autowired
    public EmailService(MailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Value("${SET_TO}")
    private String to;
    public void doSendEmailWith(EmailRequest emailRequest) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("bilgi@mersinarslannakliyat.com");
        message.setTo(to);
        message.setSubject(emailRequest.getSubject() + " - " + emailRequest.getName());
        message.setText(emailRequest.getMessage() + "\n\n" + emailRequest.getPhone());
        mailSender.send(message);
        System.out.println("Message Sent");
    }

}
