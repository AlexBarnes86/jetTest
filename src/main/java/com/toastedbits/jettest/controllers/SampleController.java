package com.toastedbits.jettest.controllers;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/hello")
public class SampleController {

	@RequestMapping(method = RequestMethod.GET)
	public String hello(ModelMap model) {
		model.addAttribute("msg", "hello world");
		return "hello";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(ModelMap model) {
		return "redirect:/spring/hello";
	}
}
