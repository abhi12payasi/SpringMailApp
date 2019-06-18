package com.app.sender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class AppMailSender { 
	@Autowired
	private JavaMailSender sender;
	public boolean sendMail(
			String to,
			String subject,
			String text,
			FileSystemResource file
			) {
		boolean flag=false;
		//1. creating MimeMessage Object
		MimeMessage mimeMessage=sender.createMimeMessage(); 
		try {
			//2. Create helper class object
			MimeMessageHelper helper=new MimeMessageHelper(mimeMessage, file!=null ?true:false);
			
			//3.  Set message Details
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			helper.setFrom("abhi12payasi@gmail.com");
			if(file!=null)
				helper.addAttachment(file.getFilename(), file);
			
			//4.send
			sender.send(mimeMessage);
			flag=true;
		} catch (MessagingException e) {
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
}
