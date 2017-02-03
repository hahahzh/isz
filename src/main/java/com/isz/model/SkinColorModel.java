package com.isz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_skincolor")
public class SkinColorModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	private String skincolor_name;
	

	public SkinColorModel() {
	}

	




	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public String getSkincolor_name() {
		return skincolor_name;
	}






	public void setSkincolor_name(String skincolor_name) {
		this.skincolor_name = skincolor_name;
	}






	public String toString() {
		return String.format("skincolor[name='%s']", skincolor_name);
	}
}
