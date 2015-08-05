package com.jjorae.usinggooglesmtp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("sendMailSerivce")
public class SendMailService {

	@Autowired
	private MailSender mailSender;
	
	public void sendMail(SimpleMailMessage message) {
		
		mailSender.send(message);
		
	}
	
}
