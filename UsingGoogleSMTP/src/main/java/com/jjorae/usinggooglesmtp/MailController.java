package com.jjorae.usinggooglesmtp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mail")
public class MailController {
	
	private static final Logger logger = LoggerFactory.getLogger(MailController.class);

	@Autowired
	private SendMailService sendMailService;
	
	@RequestMapping("/send")
	public String send(@RequestParam(required=false) String from, Model model) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		if(from != null && !from.equals("")) {
			
			logger.info("from email address : " + from);
			
			// 안먹힘..smtp 설정한 부분에 있는 메일로만 보내짐..
			message.setFrom(from);

		}
		
		message.setTo("ossri_dev@rockplace.co.kr");
		message.setSubject("Sending mail test using Google SMTP");
		message.setText("잘 가나요?");
		
		try {
			
			sendMailService.sendMail(message);
			
		} catch (Exception ex) {
			model.addAttribute("error_msg", ex.getMessage());
			
			return "home";
			
		}
		
		return "complete";
		 
	}
	
}
