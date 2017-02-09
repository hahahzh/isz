package com.isz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.isz.model.Storehouse;
import com.isz.repository.StorehouseRepository;




@RestController
@RequestMapping("/storehouse")
public class StorehouseController {

	@Autowired
	private StorehouseRepository storehouseRepository;
	
	@GetMapping(value = "/list")
	public ModelAndView list() {
		Iterable<Storehouse> storehouses = this.storehouseRepository.findAll();
		return new ModelAndView("storehouses/list", "storehouses", storehouses);
	}
	
}