package com.isz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.UserDetailModel;


public interface UserDetailModelRepository extends JpaRepository<UserDetailModel, Serializable>, CrudRepository<UserDetailModel, Serializable>{
	
	
	@Query("select a from UserDetailModel a where a.user.id=?1")
	public UserDetailModel findByUserId(Long user_id);
}
