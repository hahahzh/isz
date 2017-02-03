package com.isz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.BodySize;


public interface BodySizeRepository extends JpaRepository<BodySize, Serializable>, CrudRepository<BodySize, Serializable>{


}
