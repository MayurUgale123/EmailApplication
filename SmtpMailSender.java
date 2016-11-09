package com.example;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Controller
public class SmtpMailSender {

	public void initialize(String fname, String femail, String toemail, String cc, String subject, String bcc, String body){
		
		String host = "10.0.1.44";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.auth", "false");
		Session session = Session.getDefaultInstance(properties);
		
		try {
			System.out.println("Send mail start");
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(femail));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toemail));
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
			message.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));

			// Set Subject: header field
			message.setSubject(subject);

			// Now set the actual message
			message.setText(body);

			// Send message
			System.out.println("Before Send ... ");
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
}
