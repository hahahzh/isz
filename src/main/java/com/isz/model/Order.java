package com.isz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Table(name = "order_info")
@Entity
public class Order  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private Goods goods;

	@NotNull
	private Integer num;
	
	
	private String order_unit;
	
	@Column(columnDefinition="TIMESTAMP")
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date sales_date; 
	
	private String memo;
	// 1 未发出 2 已发出 3 在途 4 签收
	private Integer logistics;
	// 1 未支付 2 取消 3 已支付
	private Integer pay;
	
	@ManyToOne
	private UserModel user;
	
	private String user_tmp;
		
	@Column(columnDefinition="TIMESTAMP")
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateDate;

	@Column(columnDefinition="TIMESTAMP")
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@org.hibernate.annotations.CreationTimestamp
	private Date createDate;
	
	private int isShow;
	

	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}



	public Integer getNum() {
		return num;
	}




	public void setNum(Integer num) {
		this.num = num;
	}




	public String getOrder_unit() {
		return order_unit;
	}




	public void setOrder_unit(String order_unit) {
		this.order_unit = order_unit;
	}




	public Date getSales_date() {
		return sales_date;
	}




	public void setSales_date(Date sales_date) {
		this.sales_date = sales_date;
	}




	public String getMemo() {
		return memo;
	}




	public void setMemo(String memo) {
		this.memo = memo;
	}




	public Integer getLogistics() {
		return logistics;
	}




	public void setLogistics(Integer logistics) {
		this.logistics = logistics;
	}




	public Integer getPay() {
		return pay;
	}




	public void setPay(Integer pay) {
		this.pay = pay;
	}




	public Date getUpdateDate() {
		return updateDate;
	}




	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}




	public UserModel getUser() {
		return user;
	}




	public Date getCreateDate() {
		return createDate;
	}




	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}




	public String getUser_tmp() {
		return user_tmp;
	}




	public void setUser_tmp(String user_tmp) {
		this.user_tmp = user_tmp;
	}




	public void setUser(UserModel user) {
		this.user = user;
	}

	public int getIsShow() {
		return isShow;
	}



	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}


	public Goods getGoods() {
		return goods;
	}




	public void setGoods(Goods goods) {
		this.goods = goods;
	}






	public String toString() {
		return goods.getName();
	}

}