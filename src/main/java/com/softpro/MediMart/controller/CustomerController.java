package com.softpro.MediMart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@GetMapping("/home")
	public String ShowCustomerDashboard()
	{
		return "/customer/customerdashboard";
	}
	@GetMapping("/response")
     public String ShowResponse()
     {
    	 return "/customer/giveresponse";
     }
}
