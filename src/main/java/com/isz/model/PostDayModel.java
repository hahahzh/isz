package com.isz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_postday")
public class PostDayModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;


	private String postday_name;
	

	public PostDayModel() {
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}




	public String getPostday_name() {
		return postday_name;
	}



	public void setPostday_name(String postday_name) {
		this.postday_name = postday_name;
	}



	public String toString() {
		return String.format("postday[name='%s']", postday_name);
	}
}
