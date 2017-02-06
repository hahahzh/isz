package com.isz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Index;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "user")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@NotNull
	@Size(max=20)
	private String name;
	
	@Size(max=20)
	private String nickname;
	
	@NotNull
	@Size(max=30,min=6)
	public String pwd;
	
	// 0 男 1 女
	public Byte gender;
	
	public String portrait;
	
	// 1 IOS正版 2 Android 3 IOS越狱  4 IPad 5 OPad
	public int os;
	
	public String type;
	
	public Long exp;
	
	@NotNull
	@Index(name = "idx_mobile")
	public Long mobile;
	
	@Index(name = "idx_email")
	public String email;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	
	@Column(columnDefinition="TIMESTAMP",updatable = true)
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@org.hibernate.annotations.CreationTimestamp
	private Date createDate;
	
	@Column(columnDefinition="TIMESTAMP",updatable = true)
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@org.hibernate.annotations.UpdateTimestamp
	private Date updateDate;
	
	private String school;
	
	
	private String wx_id;
	
	private Integer level;
	
	private Integer point;
	
	public UserModel() {
	}




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



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public Byte getGender() {
		return gender;
	}



	public void setGender(Byte gender) {
		this.gender = gender;
	}



	public String getPortrait() {
		return portrait;
	}



	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}



	public int getOs() {
		return os;
	}



	public void setOs(int os) {
		this.os = os;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public Long getExp() {
		return exp;
	}



	public void setExp(Long exp) {
		this.exp = exp;
	}



	public Long getMobile() {
		return mobile;
	}



	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public Date getUpdateDate() {
		return updateDate;
	}



	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}



	public String getSchool() {
		return school;
	}



	public void setSchool(String school) {
		this.school = school;
	}



	public String getWx_id() {
		return wx_id;
	}



	public void setWx_id(String wx_id) {
		this.wx_id = wx_id;
	}



	public Integer getLevel() {
		return level;
	}



	public void setLevel(Integer level) {
		this.level = level;
	}



	public Integer getPoint() {
		return point;
	}



	public void setPoint(Integer point) {
		this.point = point;
	}



	public String toString() {
		return String.format("Goods[name='%s', birthday='%s']", name, birthday);
	}

}
