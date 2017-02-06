package com.isz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Table(name = "storehouse")
@Entity
public class Storehouse  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String code;
	
	private Integer num;
	
		
	@Column(columnDefinition="TIMESTAMP")
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@org.hibernate.annotations.UpdateTimestamp
	private Date updateDate;

	@Column(columnDefinition="TIMESTAMP")
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@org.hibernate.annotations.CreationTimestamp
	private Date createDate;
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public Integer getNum() {
		return num;
	}



	public void setNum(Integer num) {
		this.num = num;
	}



	public Date getUpdateDate() {
		return updateDate;
	}



	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public String toString() {
		return name;
	}

}