package com.freelance.app.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.freelance.app.util.MyConstants;

@Configuration
public class MailConfig {
	
    @Bean
    @Primary
    public JavaMailSender getJavaMailSendeGmail() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
  
        mailSender.setUsername(MyConstants.MY_EMAIL);
        mailSender.setPassword(MyConstants.MY_PASSWORD);
 
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
 
        return mailSender;
    }
    
    @Bean
    public JavaMailSender getJavaMailSenderYahoo() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.yahoo.com");
        mailSender.setPort(465);
  
        mailSender.setUsername(MyConstants.MY_EMAIL);
        mailSender.setPassword(MyConstants.MY_PASSWORD);
 
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
 
        return mailSender;
    }

}
