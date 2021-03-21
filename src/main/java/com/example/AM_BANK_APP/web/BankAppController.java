package com.example.AM_BANK_APP.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.AM_BANK_APP.domain.Tili;
import com.example.AM_BANK_APP.domain.TiliRepository;

@Controller
public class BankAppController {

	@Autowired
	private TiliRepository repository;

	@RequestMapping("/bankapp")
	public String frontpage(Model model) {

		
		List<Tili> lista = repository.listTilit();
		model.addAttribute("tilit", lista);

		return "frontpage";

	}


	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Tili tili) {
		
		return "redirect:bankapp";
	}

	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		List<Tili> lista = repository.listTilit();
		model.addAttribute("tili", lista);

		return "uusimaksu";
	}
	
	/*
	  @RequestMapping(value = "/sendMoney", method = RequestMethod.GET)
	    public String viewSendMoneyPage(Model model) {
	 
	        SendMoneyForm form = new SendMoneyForm(1L, 2L, 700d);
	 
	        model.addAttribute("sendMoneyForm", form);
	 
	        return "sendMoneyPage";
	    }
	 
	  
	    @RequestMapping(value = "/sendMoney", method = RequestMethod.POST)
	    public String processSendMoney(Model model, SendMoneyForm sendMoneyForm) {
	 
	        System.out.println("Send Money: " + sendMoneyForm.getAmount());
	 
	        try {
	            bankAccountDAO.sendMoney(sendMoneyForm.getFromAccountId(), //
	                    sendMoneyForm.getToAccountId(), //
	                    sendMoneyForm.getAmount());
	        } catch (BankTransactionException e) {
	            model.addAttribute("errorMessage", "Error: " + e.getMessage());
	            return "/sendMoneyPage";
	        }
	        return "redirect:/";
	    }
	 
	 
	 */
	}
	
	
	


