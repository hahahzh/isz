package com.isz.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Index;
import org.springframework.beans.factory.annotation.Required;



/**
 * @author Administrator
 *
 */
@Entity
@Table(name = "user_face")
public class FaceModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;


	private String face_name;
	

	public FaceModel() {
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}





	public String getFace_name() {
		return face_name;
	}



	public void setFace_name(String face_name) {
		this.face_name = face_name;
	}



	public String toString() {
		return String.format("Goods[name='%s']", face_name);
	}

}
