package com.barapp.LucasLejeune;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.barapp.LucasLejeune.model")
@EnableJpaRepositories("com.barapp.LucasLejeune.repository")
public class LucasLejeuneApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucasLejeuneApplication.class, args);
	}

}
