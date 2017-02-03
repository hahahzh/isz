package com.isz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.HairModel;


public interface HairModelRepository extends JpaRepository<HairModel, Serializable>, CrudRepository<HairModel, Serializable>{


}
