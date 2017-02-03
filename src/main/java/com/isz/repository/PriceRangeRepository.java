package com.isz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.PriceRange;


public interface PriceRangeRepository extends JpaRepository<PriceRange, Serializable>, CrudRepository<PriceRange, Serializable>{


}
