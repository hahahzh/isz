package com.isz.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.Goods;


public interface GoodsRepository extends JpaRepository<Goods, Serializable>, CrudRepository<Goods, Serializable>{
	@Query("select a from Goods a where a.isShow=1")
	public List<Goods> findAll();
	
	public Goods findByCode(String code);
}
