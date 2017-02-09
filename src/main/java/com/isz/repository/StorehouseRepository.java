package com.isz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.Storehouse;


public interface StorehouseRepository extends JpaRepository<Storehouse, Serializable>, CrudRepository<Storehouse, Serializable>{
	public Storehouse findByCode(String code);
}
