package com.example.joins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.joins.v1.model")
@EnableJpaRepositories("com.example.joins.v1.repository")
public class SpringbootJoinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJoinsApplication.class, args);
	}
	
}
