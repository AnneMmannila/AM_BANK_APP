package com.example.AM_BANK_APP.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.AM_BANK_APP.domain.Maksu;
import com.example.AM_BANK_APP.domain.Tili;
import com.example.AM_BANK_APP.domain.TiliRepository;
import com.example.AM_BANK_APP.domain.TilitapahtumaException;

@Controller
public class BankAppController {

	
	//https://o7planning.org/11661/spring-boot-jpa-and-spring-transaction
	
	@Autowired
	private TiliRepository repository;

	@RequestMapping("/bankapp")
	public String frontpage(Model model) {

		
		List<Tili> lista = repository.listTilit();
		model.addAttribute("tilit", lista);

		return "frontpage";

	}


	
	  @RequestMapping(value = "/maksu", method = RequestMethod.GET)
	    public String viewSendMoneyPage(Model model) {
	 
	        Maksu maksu = new Maksu(1L, 2L, 700d);
	 
	        model.addAttribute("uusimaksu", maksu);
	 
	        return "uusimaksu";
	    }
	 
	  
	    @RequestMapping(value = "/maksu", method = RequestMethod.POST)
	    public String processSendMoney(Model model, Maksu maksu) {
	 
	    	List<Tili> lista = repository.listTilit();
	    	model.addAttribute("tilit", lista);
	    	
	        System.out.println("Send Money: " + maksu.getMaara());
	 
	        try {
	            repository.sendMoney(maksu.getTililta(), //
	                    maksu.getTilille(), //
	                    maksu.getMaara());
	        } catch (TilitapahtumaException e) {
	            model.addAttribute("errorMessage", "Error: " + e.getMessage());
	            return "/maksu";
	        }
	        return "redirect:/bankapp";
	    }
	 
	
	}
	
	
	


