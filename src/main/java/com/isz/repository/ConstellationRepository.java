package com.isz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.Constellation;


public interface ConstellationRepository extends JpaRepository<Constellation, Serializable>, CrudRepository<Constellation, Serializable>{


}
