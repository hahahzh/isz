package com.isz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.PostDayModel;


public interface PostDayModelRepository extends JpaRepository<PostDayModel, Serializable>, CrudRepository<PostDayModel, Serializable>{


}
