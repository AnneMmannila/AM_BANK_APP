package com.example.AM_BANK_APP.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AM_BANK_APP.domain.TiliRepository;


@Controller
public class BankAppController {

	
	
	@Autowired
	private TiliRepository repository;
	
	@RequestMapping("/bankapp")
	public String frontpage(Model model) {
		model.addAttribute("tilit", repository.findAll());
		
	return "frontpage";

	}
}
