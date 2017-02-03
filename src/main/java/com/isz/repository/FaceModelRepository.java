package com.isz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.FaceModel;


public interface FaceModelRepository extends JpaRepository<FaceModel, Serializable>, CrudRepository<FaceModel, Serializable>{


}
