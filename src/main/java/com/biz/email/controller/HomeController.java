package com.biz.email.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.email.model.EmailVO;
import com.biz.email.service.EmailService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	EmailService eService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<EmailVO> eList = eService.selectAll();
		model.addAttribute("EMAILS",eList);
		return "home";
	}
	
}
