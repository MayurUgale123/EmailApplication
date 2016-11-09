package com.example;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mailDto;

@RestController
public class RootController {
		@Autowired
		private SmtpMailSender smtpMailSender;
		
		//private String fromName, fromEmail, toEmail, CC, BCC, Body, Subject;
		
		@RequestMapping("/send-mail")
		public	void sendMail(@RequestBody mailDto mailerObj) throws MessagingException {
			
		smtpMailSender.initialize(mailerObj.getFname(),
				mailerObj.getFemail(), mailerObj.getToemail(),
				mailerObj.getCc(), mailerObj.getSubject(), mailerObj.getBcc(), mailerObj.getBody());			
			
		}
	/*
		private static final String PATH = "/error";

	    @RequestMapping(value = PATH)
	    public String error() {
	        return "Error handling";
	    }

	    public String getErrorPath() {
	        return PATH;
	    }*/
}

