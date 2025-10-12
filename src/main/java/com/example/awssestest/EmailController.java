package com.example.awssestest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmailController {

	private final EmailService emailService;
	
	public EmailController(EmailService emailService) {
		this.emailService= emailService;
	}
	
	@PostMapping("/send")
	public void send(@RequestBody EmailRequest emailRequest) {
		this.emailService.doSendEmailWith(emailRequest);
	}
}
