package com.isz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.isz.model.SkinColorModel;


public interface SkinColorModelRepository extends JpaRepository<SkinColorModel, Serializable>, CrudRepository<SkinColorModel, Serializable>{


}
