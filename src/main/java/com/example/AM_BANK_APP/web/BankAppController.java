package com.example.AM_BANK_APP.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.AM_BANK_APP.domain.Maksu;
import com.example.AM_BANK_APP.domain.Tili;
import com.example.AM_BANK_APP.domain.TiliRepository;
import com.example.AM_BANK_APP.domain.TilitapahtumaException;
import com.example.AM_BANK_APP.domain.Tilitapahtumat;
import com.example.AM_BANK_APP.domain.User;
import com.example.AM_BANK_APP.domain.UserRepository;

@Controller
public class BankAppController {

	
	//https://o7planning.org/11661/spring-boot-jpa-and-spring-transaction
	
	@Autowired
	private TiliRepository repository;
	
	@Autowired
	UserRepository urepository;
	
	// RESTful service to get tilinrot
    @RequestMapping(value="/tilinrot", method = RequestMethod.GET)
    public @ResponseBody List<Tili> tiliRest() {	
        return (List<Tili>) repository.listkaikkiTilinrot();
    } 
	
    
    @RequestMapping("/login")
    public String loginpage() {
    	
    	return "login";
    };
    
	

	@RequestMapping("/bankapp")
	public String frontpage(Model model) {

		 UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        String username = user.getUsername();
	        User userNow = urepository.findByUsername(username);
		
		
		List<Tili> lista = repository.findByUser(userNow);
		model.addAttribute("tilit", lista);
		System.out.println(lista);
		
		List <Tilitapahtumat> listatapahtumat = repository.listTapahtumat(userNow);
		model.addAttribute("tilitapahtumat" , listatapahtumat);
		
		
		return "frontpage";

	}


	
	  @RequestMapping(value = "/maksu", method = RequestMethod.GET)
	    public String viewSendMoneyPage(Model model) {
		  UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        String username = user.getUsername();
	        User userNow = urepository.findByUsername(username);
		  
		  List <Tili> tilinrot  = repository.listTilinrot(userNow);
		   model.addAttribute("tilinrot", tilinrot);
		   
		   List <Tili> siirtotili = repository.listkaikkiTilinrot();
		   model.addAttribute("siirtotili", siirtotili);
	        Maksu maksu = new Maksu("", "", 0d);
	 
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
	
	
	


