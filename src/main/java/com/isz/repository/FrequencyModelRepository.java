package com.isz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.FrequencyModel;


public interface FrequencyModelRepository extends JpaRepository<FrequencyModel, Serializable>, CrudRepository<FrequencyModel, Serializable>{

}
