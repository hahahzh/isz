package com.isz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.SalesModel;


public interface SalesModelRepository extends JpaRepository<SalesModel, Serializable>, CrudRepository<SalesModel, Serializable>{

}
