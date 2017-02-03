package com.isz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_pricerange")
public class PriceRange {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;


	private String pricerange_name;
	

	public String getPricerange_name() {
		return pricerange_name;
	}



	public void setPricerange_name(String pricerange_name) {
		this.pricerange_name = pricerange_name;
	}



	public PriceRange() {
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



}
