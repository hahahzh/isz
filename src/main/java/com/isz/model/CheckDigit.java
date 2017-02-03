package com.isz.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Index;


@Table(name = "checkdigit")
@Entity
public class CheckDigit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Index(name = "checkdigit_d")
	public int d;
	public long m;
	public long updatetime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	public long getM() {
		return m;
	}
	public void setM(long m) {
		this.m = m;
	}
	public long getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(long updatetime) {
		this.updatetime = updatetime;
	}
	
	
}