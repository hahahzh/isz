package com.isz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.HierarchyModel;


public interface HierarchyModelRepository extends JpaRepository<HierarchyModel, Serializable>, CrudRepository<HierarchyModel, Serializable>{


}
