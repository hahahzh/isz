package com.isz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_hair")
public class HairModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	private String hair_name;
	

	public HairModel() {
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}




	public String getHair_name() {
		return hair_name;
	}



	public void setHair_name(String hair_name) {
		this.hair_name = hair_name;
	}



	public String toString() {
		return String.format("Hair[name='%s']", hair_name);
	}
}
