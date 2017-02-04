package com.isz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_size")
public class BodySize {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;


	private String size_name;
	

	public BodySize() {
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}





	public String getSize_name() {
		return size_name;
	}



	public void setSize_name(String size_name) {
		this.size_name = size_name;
	}



	public String toString() {
		return size_name;
	}
}
