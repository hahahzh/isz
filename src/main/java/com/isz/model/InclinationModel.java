package com.isz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_inclination")
public class InclinationModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	private String inclination_name;
	

	public InclinationModel() {
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getInclination_name() {
		return inclination_name;
	}



	public void setInclination_name(String inclination_name) {
		this.inclination_name = inclination_name;
	}



	public String toString() {
		return String.format("Inclination[inclination_name='%s']", inclination_name);
	}
}
