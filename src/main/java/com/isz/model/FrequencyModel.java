package com.isz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_frequency")
public class FrequencyModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;


	private String frequency_name;
	

	public FrequencyModel() {
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}




	public String getFace_name() {
		return frequency_name;
	}



	public void setFace_name(String frequency_name) {
		this.frequency_name = frequency_name;
	}



	public String toString() {
		return String.format("Goods[name='%s']", frequency_name);
	}
}
