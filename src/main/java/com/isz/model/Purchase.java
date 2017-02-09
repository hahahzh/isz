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


@Table(name = "purchase_info")
@Entity
public class Purchase  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String code;
	
	private String attribute;
	
	private Double nameplate_price;
	private Float rebate;
	private Double purchase_price;
	
	private String purchasing_agent;
	
	private Integer num;
	
	
	@Column(columnDefinition="TIMESTAMP")
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date purchasing_date;
	
	public String company;
	
	public String account_period;
	
	@Column(columnDefinition="TIMESTAMP")
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateDate;

	private String purchase_unit;
	
	private int isShow;
	
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



	public String getAttribute() {
		return attribute;
	}



	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}



	public Double getNameplate_price() {
		return nameplate_price;
	}



	public void setNameplate_price(Double nameplate_price) {
		this.nameplate_price = nameplate_price;
	}



	public Float getRebate() {
		return rebate;
	}



	public void setRebate(Float rebate) {
		this.rebate = rebate;
	}



	public Double getPurchase_price() {
		return purchase_price;
	}



	public void setPurchase_price(Double purchase_price) {
		this.purchase_price = purchase_price;
	}



	public String getPurchasing_agent() {
		return purchasing_agent;
	}



	public void setPurchasing_agent(String purchasing_agent) {
		this.purchasing_agent = purchasing_agent;
	}



	public Date getPurchasing_date() {
		return purchasing_date;
	}



	public void setPurchasing_date(Date purchasing_date) {
		this.purchasing_date = purchasing_date;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getAccount_period() {
		return account_period;
	}



	public void setAccount_period(String account_period) {
		this.account_period = account_period;
	}



	public Date getUpdateDate() {
		return updateDate;
	}



	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}



	public Integer getNum() {
		return num;
	}



	public void setNum(Integer num) {
		this.num = num;
	}



	public String getPurchase_unit() {
		return purchase_unit;
	}



	public void setPurchase_unit(String purchase_unit) {
		this.purchase_unit = purchase_unit;
	}



	public int getIsShow() {
		return isShow;
	}



	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}



	public String toString() {
		return name;
	}

}