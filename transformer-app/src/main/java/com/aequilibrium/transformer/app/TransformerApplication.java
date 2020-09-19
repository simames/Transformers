package com.aequilibrium.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.aequilibrium.transformer")
@EnableJpaRepositories("com.aequilibrium.transformer.persistence")
@EntityScan("com.aequilibrium.transformer.persistence.*")
public class TransformerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransformerApplication.class, args);
	}


}
