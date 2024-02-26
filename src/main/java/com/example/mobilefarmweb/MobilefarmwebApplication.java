package com.example.mobilefarmweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.mobilefarmweb.repository")
@ComponentScan("com.example.mobilefarmweb.*")
public class MobilefarmwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobilefarmwebApplication.class, args);
	}

	@Bean
	public ResourceBundleMessageSource getResourceBundleMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.addBasenames("message");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
}
