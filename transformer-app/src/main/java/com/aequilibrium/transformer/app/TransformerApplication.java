package com.aequilibrium.transformer.app;

import com.aequilibrium.transformer.api.model.TransformerEnumType;
import com.aequilibrium.transformer.persistence.model.TransformerTypeEntity;
import com.aequilibrium.transformer.service.logic.TransformerService;
import com.aequilibrium.transformer.service.model.TransformerType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.aequilibrium.transformer")
@EnableJpaRepositories("com.aequilibrium.transformer.persistence")
@EntityScan("com.aequilibrium.transformer.persistence.*")
public class TransformerApplication implements CommandLineRunner {


	private final TransformerService service;

	public TransformerApplication(TransformerService service) {
		this.service = service;
	}


	public static void main(String[] args) {
		SpringApplication.run(TransformerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		TransformerType descpticonType =service.createTransformerType(new TransformerType(TransformerEnumType.DESEPTICAN.getCode(),TransformerEnumType.DESEPTICAN.getDescription()));
		TransformerType transformerType  =service.createTransformerType(new TransformerType(TransformerEnumType.AUTOBOT.getCode(),TransformerEnumType.AUTOBOT.getDescription()));
	}
}
