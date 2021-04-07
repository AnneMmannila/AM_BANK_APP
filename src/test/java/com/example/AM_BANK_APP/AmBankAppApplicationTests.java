package com.example.AM_BANK_APP;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.AM_BANK_APP.web.BankAppController;




@ExtendWith(SpringExtension.class)
@SpringBootTest
class AmBankAppApplicationTests {

	@Autowired
	private BankAppController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}