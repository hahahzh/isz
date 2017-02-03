package com.isz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_body")
public class BodyModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;


	private String body_name;
	

	public BodyModel() {
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}




	public String getBody_name() {
		return body_name;
	}



	public void setBody_name(String body_name) {
		this.body_name = body_name;
	}



	public String toString() {
		return String.format("Body[name='%s']", body_name);
	}
}
