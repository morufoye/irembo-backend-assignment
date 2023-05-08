package com.assignment.backend;

import com.assignment.backend.entity.UserAccount;
import com.assignment.backend.enums.AccountVerificationEnum;
import com.assignment.backend.enums.GenderEnum;
import com.assignment.backend.enums.MaritalStatusEnum;
import com.assignment.backend.repo.UserAccountRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class SpringReactiveCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveCrudApplication.class, args);
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}


}
