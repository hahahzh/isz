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


@Table(name = "goods_info")
@Entity
public class Goods  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String code;
	
	private Integer num;//销售数量
	@NotNull
	private Double nameplate_price;
	@NotNull
	private Float rebate;//折扣
	@NotNull
	private Double sales_price;
	
	private String memo;
	
	@Column(columnDefinition="TIMESTAMP")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_from;
	@Column(columnDefinition="TIMESTAMP")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用
	private Date date_end;
	
		
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
	
	private String goods_unit;
	
	private int isShow;

	public Long getId() {
		return id;
	}



	public String getGoods_unit() {
		return goods_unit;
	}



	public void setGoods_unit(String goods_unit) {
		this.goods_unit = goods_unit;
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



	public Double getSales_price() {
		return sales_price;
	}



	public void setSales_price(Double sales_price) {
		this.sales_price = sales_price;
	}



	public String getMemo() {
		return memo;
	}



	public void setMemo(String memo) {
		this.memo = memo;
	}



	public Date getDate_from() {
		return date_from;
	}



	public void setDate_from(Date date_from) {
		this.date_from = date_from;
	}



	public Date getDate_end() {
		return date_end;
	}



	public void setDate_end(Date date_end) {
		this.date_end = date_end;
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