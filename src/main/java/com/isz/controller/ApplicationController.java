package com.isz.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isz.model.UserDetailModel;
import com.isz.model.UserModel;
import com.isz.repository.CheckDigitRepository;
import com.isz.repository.UserDetailModelRepository;
import com.isz.repository.UserModelRepository;
import com.isz.utils.DateUtil;
import com.isz.utils.SendSMS;
import com.isz.utils.StringUtil;



@RestController
@RequestMapping("/")
public class ApplicationController {
	
	@GetMapping
	public ModelAndView list() {
		return new ModelAndView("home");
	}
	
	
}
