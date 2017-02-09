package com.isz.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.Order;


public interface OrderRepository extends JpaRepository<Order, Serializable>, CrudRepository<Order, Serializable>{
	@Query("select a from Order a where a.isShow=1")
	public List<Order> findAll();
}
