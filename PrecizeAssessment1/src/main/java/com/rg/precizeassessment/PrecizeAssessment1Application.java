package com.rg.precizeassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.rg.precizeassessment.*")
@EntityScan(basePackages= {"com.rg.precizeassessment.entities"})
@ComponentScan(basePackages= {"com.rg.precizeassessment.controllers","com.rg.precizeassessment.Services","com.rg.precizeassessment.Repository","com.rg.precizeassessment.Exceptions"})
public class PrecizeAssessment1Application {

	public static void main(String[] args) {
		SpringApplication.run(PrecizeAssessment1Application.class, args);
	}

}
