package com.isz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.InclinationModel;


public interface InclinationModelRepository extends JpaRepository<InclinationModel, Serializable>, CrudRepository<InclinationModel, Serializable>{


}
