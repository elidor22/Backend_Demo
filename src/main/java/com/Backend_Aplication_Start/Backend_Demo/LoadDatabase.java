package com.Backend_Aplication_Start.Backend_Demo;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
    CommandLineRunner initDatabase() {
		return initDatabase();
	}

	@Bean
    CommandLineRunner initDatabase(UserRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new User("Me", "Whatever")));
			log.info("Preloading " + repository.save(new User("Slipknot", "Metal Band")));
			log.info("Preloading"+repository.save(new User("Elidor", "THe dude that is developing this stuff")));
		};
	}
}
