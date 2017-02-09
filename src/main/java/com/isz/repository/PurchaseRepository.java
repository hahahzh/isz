package com.isz.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.Purchase;


public interface PurchaseRepository extends JpaRepository<Purchase, Serializable>, CrudRepository<Purchase, Serializable>{
	
	@Query("select a from Purchase a where a.isShow=1")
	public List<Purchase> findAll();

}
