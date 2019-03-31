package com.biz.email.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.email.model.EmailVO;
import com.biz.email.service.EmailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class EmailController {

	@Autowired
	EmailService eService;
	
	@RequestMapping(value="email_form",method=RequestMethod.GET)
	public String email(Model model) {
		model.addAttribute("button","insert");
		return "email_form";
	}
	
	@RequestMapping(value="email_list",method=RequestMethod.GET)
	public String list(Model model) {
		List<EmailVO> eList = eService.selectAll();
		model.addAttribute("EMAILS",eList);
		return "home";
	}
	
	@RequestMapping(value="email_form", method=RequestMethod.POST)
	public String insert(Model model, @ModelAttribute EmailVO emailVO,
						@RequestParam("s_filea") MultipartFile s_filea,
						@RequestParam("s_fileb") MultipartFile s_fileb
						) {
		
		eService.insert(emailVO, s_filea, s_fileb);
	
		return "redirect:/";
		
	}
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String updateEmail(Model model, @RequestParam long id
			
								) {
		
	
		model.addAttribute("VO", eService.findById(id));
		model.addAttribute("button","update");
		return "email_form";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String updateEmail(Model model, 
							@ModelAttribute EmailVO emailVO,
							@RequestParam("s_filea") MultipartFile s_filea,
							@RequestParam("s_fileb") MultipartFile s_fileb,
							BindingResult result
							) {
		log.debug(emailVO.toString());
		eService.update(emailVO,s_filea, s_fileb);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String deleteEmail(@RequestParam long id) {
		
		//log.debug("pass");
		eService.delete(id);
		
		return "redirect:/";
	}
	
	
	
	
	
}
