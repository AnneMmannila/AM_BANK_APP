package com.example.AM_BANK_APP.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BankAppController {

	@RequestMapping("/bankapp")
	public String frontpage() {
	return "frontpage";

	}
}
