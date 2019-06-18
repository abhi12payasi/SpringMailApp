package com.app.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource("app.properties")
@ComponentScan("com.app")
public class AppConfig {
	@Autowired
	private Environment env;
	@Bean
	public JavaMailSenderImpl jms() {
		JavaMailSenderImpl m=new JavaMailSenderImpl();
		m.setHost(env.getProperty("spring.mail.host"));
		m.setPort(Integer.parseInt(env.getProperty("spring.mail.port")));
		m.setUsername(env.getProperty("spring.mail.un"));
		m.setPassword(env.getProperty("spring.mail.pwd"));
		m.setJavaMailProperties(props());
		return m;
	}
	
	@Bean
	public Properties props() {
		Properties p= new Properties();
		p.put("mail.smtp.starttls.enable","true");
		p.put("mail.smtp.auth","true");
		return p;
	}
}
