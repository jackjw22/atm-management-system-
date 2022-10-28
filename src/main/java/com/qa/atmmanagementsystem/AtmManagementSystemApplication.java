package com.qa.atmmanagementsystem;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
@EnableWebMvc


public class AtmManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmManagementSystemApplication.class, args);
	}

}
