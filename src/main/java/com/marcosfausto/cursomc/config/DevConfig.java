package com.marcosfausto.cursomc.config;

import java.text.ParseException;

import com.marcosfausto.cursomc.services.EmailService;
import com.marcosfausto.cursomc.services.MockEmailService;
import com.marcosfausto.cursomc.services.SmtpEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcosfausto.cursomc.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if(! strategy.equals("create")) {
			return false;
		}
		
		dbService.instantiateTestDatabase();
		return true;
	}

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

}
