package com.isz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.isz.model.Admin;
import com.isz.repository.AdminRepository;



@RestController
@RequestMapping("/")
public class ApplicationController {
	@Autowired
	private AdminRepository adminRepository;
	@GetMapping
	public ModelAndView home0() {
		return new ModelAndView("home");
	}
	
	@GetMapping("/home")
	public ModelAndView home1() {
		return new ModelAndView("home");
	}
	
	 @RequestMapping("/admin")
	 public ModelAndView login() {
		 return new ModelAndView("admin");
	 }
	 
	 @RequestMapping("/memu")
	 public ModelAndView memu() {
		 return new ModelAndView("memu");
	 }
	
	 @RequestMapping(value = "/authentication",method=RequestMethod.POST)
	 public ModelAndView auth(@RequestParam(value="username",required = true) String username, @RequestParam(value="password",required = true) String password) {
		 
		 Admin admin = adminRepository.findByName(username);
		 if(admin == null){
			 if(username.equals("admin") && password.equals("admin")){
				 return new ModelAndView("memu");
			 }else{
				 return new ModelAndView("admin");
			 }
		 }else{
			 if(password.equals(admin.getPwd())){
				 return new ModelAndView("admin");
			 }else{
				 return new ModelAndView("memu");
			 }
		 }
	 }
}
