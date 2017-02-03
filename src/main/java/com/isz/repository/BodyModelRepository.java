package com.isz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.BodyModel;


public interface BodyModelRepository extends JpaRepository<BodyModel, Serializable>, CrudRepository<BodyModel, Serializable>{

}
