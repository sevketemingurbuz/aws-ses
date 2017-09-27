package com.example.awssestest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

@SpringBootApplication
public class AwsSesTestApplication {

    private final MailSender mailSender;

    @Autowired
    public AwsSesTestApplication(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AwsSesTestApplication.class, args);
        try {
            doSendEmailWith(context);
        } finally {
            context.close();
        }
    }

    private static void doSendEmailWith(ApplicationContext context) {
        MailSender sender = context.getBean(AwsSesTestApplication.class).mailSender;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("<YOUR EMAIL>@gmail.com");
        message.setTo("<YOUR EMAIL>@gmail.com");
        message.setSubject("Hello SES");
        message.setText("Body text - Java");
        sender.send(message);
        System.out.println("Message Sent");
    }
}
