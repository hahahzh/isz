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
import org.springframework.validation.ObjectError;
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
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserModelRepository userModelRepository;
	@Autowired
	private UserDetailModelRepository userDetailModelRepository;
	@Autowired
	private SendSMS sendSMS;
	@Autowired
	private CheckDigitRepository checkDigitRepository;
	@GetMapping(value = "/list")
	public ModelAndView list() {
		Iterable<UserModel> users = this.userModelRepository.findAll();
		return new ModelAndView("users/list", "users", users);
	}
	
	@RequestMapping(value="/reg", method=RequestMethod.GET)
	public ModelAndView regForm(@ModelAttribute UserModel user) {
		return new ModelAndView("users/register", "user", user);
		
	}
	
	/**
	 * 注册发送验证码
	 * 
	 * @param mobile
	 * @param cd
	 * @param redirect
	 * @return
	 */
	@RequestMapping(value="/sendCD",method=RequestMethod.POST)
	public ModelAndView checkDigit(@RequestParam(value="mobile",required = true) String mobile,
			@ModelAttribute UserModel user, 
			BindingResult result,
			RedirectAttributes redirect) {
		
		user = userModelRepository.findByMobile(Long.parseLong(mobile.trim()));
		if(user != null){
			redirect.addFlashAttribute("globalMessage", "您已经注册过啦！");
			 
			result.addError(new ObjectError("globalMessage", "您已经注册过啦！"));
			return new ModelAndView("users/register", "formErrors", result.getAllErrors());
		}
		
		try {
			sendSMS.checkDigit(Long.parseLong(mobile.trim()));
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("users/register", "globalMessage", "发送验证码失败，请重新再试");
		}
		redirect.addAttribute("globalMessage", "验证码发送成功");
		return new ModelAndView("users/register","user", user);
		
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@Transactional
	public ModelAndView reg(UserModel user,@RequestParam(value="cd",required = true) Integer cd, Errors result, RedirectAttributes redirect) {
		Map<String,String> errors = new HashMap<String, String>();
		if(user == null){
			errors.put("userError", "请输入参数");
		}
		if(user.mobile == null){
			errors.put("mobileError", "请输入手机号");
		}
		if(StringUtil.isEmpty(user.pwd)){
			errors.put("pwdError", "请输入密码");
		}
		
		if(userModelRepository.findByMobile(user.mobile) != null){
			errors.put("regError", "您已注册了");
			
		}
		
		if(user.mobile != null && checkDigitRepository.findByDAndM(cd, user.mobile) == null){
			errors.put("cdError", "验证码不正确");
		}
		
		if(!errors.isEmpty()){
			return new ModelAndView("users/register", errors);
		}
		
		user.setName("帅哥");
		user.setCreateDate(DateUtil.newDate());
		user.setUpdateDate(DateUtil.newDate());
		user = this.userModelRepository.save( user);
		UserDetailModel userdetail = new UserDetailModel();
		userdetail.setUser(user);
		userdetail.setAddress("还没有写地址");
		userdetail.setHeight(0);
		userdetail.setWeight(0);
		userdetail.setUpdateDate(DateUtil.newDate());
		userDetailModelRepository.save(userdetail);
		redirect.addFlashAttribute("globalMessage", "注册成功啦！赶快填写个人信息");
		return new ModelAndView("redirect:/user/form/{user.id}", "user.id", user.getId());		
	}

	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") UserModel user) {
		return new ModelAndView("users/view", "user", user);
	}

	@RequestMapping(value = "/form/{id}",method=RequestMethod.GET)
	public ModelAndView createForm(@PathVariable("id")Long id, UserModel user) {
		user = this.userModelRepository.findOne(id);
		if(user == null)return new ModelAndView("users/register", "user", user);
		return new ModelAndView("users/form", "user", user);
	}

	@RequestMapping(value = "/form",method=RequestMethod.POST)
	public ModelAndView create(@Valid UserModel user, BindingResult result,
			RedirectAttributes redirect) throws ParseException {
		
		user.setUpdateDate(new Date());
		
		if (result.hasErrors()) {
			return new ModelAndView("users/form", "formErrors", result.getAllErrors());
		}
		user = this.userModelRepository.save( user);
		redirect.addFlashAttribute("globalMessage", "Successfully created a new user");
		return new ModelAndView("redirect:/userDetail/form/{user.id}", "user.id", user.getId());
	}

	@RequestMapping("foo")
	public String foo() {
		throw new RuntimeException("Expected exception in controller");
	}

	@GetMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		this.userModelRepository.delete(id);
		Iterable<UserModel> users = this.userModelRepository.findAll();
		return new ModelAndView("users/list", "users", users);
	}

	@GetMapping(value = "modify/{id}")
	public ModelAndView modifyForm(@PathVariable("id") UserModel user) {
		return new ModelAndView("users/form", "user", user);
	}
}
