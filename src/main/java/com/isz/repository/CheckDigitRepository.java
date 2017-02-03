package com.isz.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.CheckDigit;


public interface CheckDigitRepository extends JpaRepository<CheckDigit, Serializable>, CrudRepository<CheckDigit, Serializable>{

	 public List<CheckDigit> findByM(Integer m);
	 
	 public CheckDigit findByDAndM(int d, Long m);

}
