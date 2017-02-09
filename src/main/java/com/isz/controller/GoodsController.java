package com.isz.controller;

import java.text.ParseException;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isz.model.Goods;
import com.isz.model.Storehouse;
import com.isz.repository.GoodsRepository;
import com.isz.utils.DateUtil;



@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsRepository goodsRepository;

	
	@GetMapping(value = "/list")
	public ModelAndView list() {
		Iterable<Goods> goodss = this.goodsRepository.findAll();
		return new ModelAndView("goodss/list", "goodss", goodss);
	}
	
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Goods goods) {
		return new ModelAndView("goodss/view", "goods", goods);
	}
	
	@RequestMapping(value = "/form",method=RequestMethod.GET)
	public ModelAndView createForm(@PathVariable("id")Long id, Goods goods) {
		return new ModelAndView("goodss/form", "goods", goods);
	}
	
	@RequestMapping(value = "/form",method=RequestMethod.POST)
	@Transactional
	public ModelAndView create(@Valid Goods goods, BindingResult result,
			RedirectAttributes redirect) throws ParseException {
		
		goods.setUpdateDate(DateUtil.newDate());
		goods.setIsShow(1);
		goods.setCreateDate(DateUtil.newDate());
		goods.setNum(0);
		
		
		if (result.hasErrors()) {
			return new ModelAndView("goodss/form", "formErrors", result.getAllErrors());
		}
		goods = this.goodsRepository.saveAndFlush(goods);
		
		redirect.addFlashAttribute("globalMessage", "Successfully created a new goods");
		return new ModelAndView("redirect:/goodss/view/{id}", "id", goods.getId());
	}
	
	@GetMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		Goods goods = this.goodsRepository.findOne(id);
		goods.setIsShow(0);
		this.goodsRepository.saveAndFlush(goods);
		Iterable<Goods> goodss = this.goodsRepository.findAll();
		return new ModelAndView("goodss/list", "goodss", goodss);
	}

}