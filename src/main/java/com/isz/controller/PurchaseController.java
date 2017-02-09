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

import com.isz.model.Purchase;
import com.isz.model.Storehouse;
import com.isz.repository.PurchaseRepository;
import com.isz.repository.StorehouseRepository;
import com.isz.utils.DateUtil;



@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseRepository purchaseRepository;
	@Autowired
	private StorehouseRepository storehouseRepository;
	
	@GetMapping(value = "/list")
	public ModelAndView list() {
		Iterable<Purchase> purchases = this.purchaseRepository.findAll();
		return new ModelAndView("purchases/list", "purchases", purchases);
	}
	
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Purchase purchase) {
		return new ModelAndView("purchases/view", "purchase", purchase);
	}
	
	@RequestMapping(value = "/form",method=RequestMethod.GET)
	public ModelAndView createForm(@PathVariable("id")Long id, Purchase purchase) {
		return new ModelAndView("purchases/form", "purchase", purchase);
	}
	
	@RequestMapping(value = "/form",method=RequestMethod.POST)
	@Transactional
	public ModelAndView create(@Valid Purchase purchase, BindingResult result,
			RedirectAttributes redirect) throws ParseException {
		
		purchase.setUpdateDate(DateUtil.newDate());
		purchase.setIsShow(1);
		if(purchase.getId() != null){
			purchase.setPurchasing_date(DateUtil.newDate());
		}
		
		if (result.hasErrors()) {
			return new ModelAndView("purchases/form", "formErrors", result.getAllErrors());
		}
		purchase = this.purchaseRepository.save(purchase);
		
		Storehouse sh = null;
		sh = this.storehouseRepository.findByCode(purchase.getCode());
		if(sh == null){
			sh = new Storehouse();
			sh.setCode(purchase.getCode());
			sh.setCreateDate(DateUtil.newDate());
			sh.setName(purchase.getName());
			sh.setNum(purchase.getNum());
		}
		sh.setUpdateDate(DateUtil.newDate());
		sh.setNum(sh.getNum()+purchase.getNum());
		this.storehouseRepository.saveAndFlush(sh);
		redirect.addFlashAttribute("globalMessage", "Successfully created a new purchase");
		
		return new ModelAndView("redirect:/purchases/view/{id}", "id", purchase.getId());
	}
	
	@GetMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		Purchase purchase = this.purchaseRepository.findOne(id);
		purchase.setIsShow(0);
		this.purchaseRepository.saveAndFlush(purchase);
		Iterable<Purchase> purchases = this.purchaseRepository.findAll();
		return new ModelAndView("purchases/list", "purchases", purchases);
	}

}
