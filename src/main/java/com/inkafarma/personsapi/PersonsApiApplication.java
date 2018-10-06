package com.inkafarma.personsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;

@SpringBootApplication(exclude = {MongoRepositoriesAutoConfiguration.class})
public class PersonsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonsApiApplication.class, args);
	}
}
