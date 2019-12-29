package com.project.cari.hobi.mainservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MainserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainserviceApplication.class, args);
	}

}
