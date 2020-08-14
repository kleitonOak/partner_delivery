package com.ze.challenge.partner.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ze.challenge.partner")
public class PartnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartnerApplication.class, args);
	}

}
