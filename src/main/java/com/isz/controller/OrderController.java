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
import com.isz.model.Order;
import com.isz.model.Storehouse;
import com.isz.model.UserModel;
import com.isz.repository.GoodsRepository;
import com.isz.repository.OrderRepository;
import com.isz.repository.StorehouseRepository;
import com.isz.repository.UserModelRepository;
import com.isz.utils.DateUtil;



@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private StorehouseRepository storehouseRepository;

	@Autowired
	private GoodsRepository goodsRepository;
	
	@Autowired
	private UserModelRepository userModelRepository;
	
	@GetMapping(value = "/list")
	public ModelAndView list() {
		Iterable<Order> orders = this.orderRepository.findAll();
		return new ModelAndView("orders/list", "orders", orders);
	}
	
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Order order) {
		return new ModelAndView("orders/view", "order", order);
	}
	
	@RequestMapping(value = "/form",method=RequestMethod.GET)
	public ModelAndView createForm(@PathVariable("id")Long id, Order order) {
		return new ModelAndView("orders/form", "order", order);
	}
	
	@RequestMapping(value = "/form",method=RequestMethod.POST)
	@Transactional
	public ModelAndView create(@Valid Order order, BindingResult result,
			RedirectAttributes redirect) throws ParseException {
		
		UserModel user = this.userModelRepository.findByMobile(Long.parseLong(order.getUser_tmp()));
		if(user == null)return new ModelAndView("orders/form", "formErrors", "无此用户");
		
		Goods goods = this.goodsRepository.findByCode(order.getCode());
		if(goods == null)return new ModelAndView("orders/form", "formErrors", "无此商品");
		
		Storehouse storehouse = this.storehouseRepository.findByCode(order.getCode());
		if(storehouse == null || storehouse.getCode() == null || storehouse.getNum()<1 || storehouse.getNum() - order.getNum()<0){
			return new ModelAndView("orders/form", "formErrors", "无库存");
		}
		
		storehouse.setNum(storehouse.getNum() - order.getNum());
		storehouse.setUpdateDate(DateUtil.newDate());
		this.storehouseRepository.saveAndFlush(storehouse);
		
		order.setSales_date(DateUtil.newDate());
		order.setLogistics(1);
		order.setPay(1);
		order.setUser(user);
		order.setUpdateDate(DateUtil.newDate());
		order.setIsShow(1);
		order.setCreateDate(DateUtil.newDate());
		
		order = this.orderRepository.saveAndFlush(order);
		
		goods.setNum(goods.getNum()+order.getNum());
		this.goodsRepository.saveAndFlush(goods);
		
		redirect.addFlashAttribute("globalMessage", "Successfully created a new order");
		return new ModelAndView("redirect:/orders/view/{id}", "id", order.getId());
	}
	
	@GetMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		Order order = this.orderRepository.findOne(id);
		order.setIsShow(0);
		this.orderRepository.saveAndFlush(order);
		Iterable<Order> orders = this.orderRepository.findAll();
		return new ModelAndView("orders/list", "orders", orders);
	}

}