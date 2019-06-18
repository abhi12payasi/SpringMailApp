package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.app.config.AppConfig;
import com.app.sender.AppMailSender;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		AppMailSender sender=ac.getBean("appMailSender",AppMailSender.class);
		String to= "abhi12payasi@gmail.com";
		String subject= "Mail via Spring Mailing";
		String text= " find attachment";
		FileSystemResource file=null;
		//FileSystemResource file=new FileSystemResource("");
		boolean isSent=sender.sendMail(to, subject, text, file);
		System.out.println("Mail  Sent : "+isSent);
	}
}