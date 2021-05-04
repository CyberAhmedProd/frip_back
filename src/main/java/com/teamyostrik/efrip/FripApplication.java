package com.teamyostrik.efrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class FripApplication {

	public static void main(String[] args) {
		SpringApplication.run(FripApplication.class, args);
	}

}
