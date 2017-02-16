package com.isz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.Admin;


public interface AdminRepository extends JpaRepository<Admin, Serializable>, CrudRepository<Admin, Serializable>{
	public Admin findByName(String name);
}
