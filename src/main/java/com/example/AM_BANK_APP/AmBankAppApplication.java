package com.example.AM_BANK_APP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.AM_BANK_APP.domain.Tili;
import com.example.AM_BANK_APP.domain.TiliRepository;
import com.example.AM_BANK_APP.domain.Tilitapahtumat;
import com.example.AM_BANK_APP.domain.TilitapahtumatRepository;



@SpringBootApplication
public class AmBankAppApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(AmBankAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner tilirunner(TiliRepository repository, TilitapahtumatRepository trepos) {
		return (args) -> {
			
			repository.save(new Tili("FIA123456", 1000.0, "Anna A"));
			repository.save(new Tili("FIB123456", 2000.0, "Bertta B"));	
			
			trepos.save(new Tilitapahtumat(200.0)); 
		};

		}
	
	
}

