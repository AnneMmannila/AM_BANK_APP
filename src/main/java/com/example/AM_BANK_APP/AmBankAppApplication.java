package com.example.AM_BANK_APP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.AM_BANK_APP.domain.Tili;
import com.example.AM_BANK_APP.domain.TiliRepository;
import com.example.AM_BANK_APP.domain.User;
import com.example.AM_BANK_APP.domain.UserRepository;

//For testing
//@ComponentScan(basePackages = {"com.example.AM_BANK_APP.domain"}) 
@SpringBootApplication
public class AmBankAppApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(AmBankAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner tilirunner(TiliRepository repos, UserRepository urepository) {
		return (args) -> {
			
			repos.insertWithQuery(new Tili("FIA123456", 2000.0, "Anna A"));
			repos.insertWithQuery(new Tili("FIB123456", 2000.0, "Bertta B"));
			
			
			//https://www.bcryptcalculator.com/
			User user1 = new User("Anna A", "$2a$10$N2FoMOl3ZyKadKQA56SdFO5C14UykDwtcwnbaYfS3AZwt1kPigAZG","anna@gmail.com", "Anna A");
			User user2 = new User("Bertta B", "$2a$10$NJPEOMYVNbE0Z6Z5qogVJu3EceZA7F21/5rbbPmm2CpLPZ4dBD.xu","bertta@gmail.com", "Bertta B");
			urepository.deleteAll();
			urepository.save(user1);
			urepository.save(user2);
			
		};

		}
	
	
}

