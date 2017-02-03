package com.isz.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.UserModel;


public interface UserModelRepository extends JpaRepository<UserModel, Serializable>, CrudRepository<UserModel, Serializable>{
	
	public UserModel findByMobile(Long mobile);

}
