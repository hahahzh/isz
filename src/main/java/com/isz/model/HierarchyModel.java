package com.isz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_hierarchy")
public class HierarchyModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;


	private String hierarchy_name;
	

	public HierarchyModel() {
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}





	public String getHierarchy_name() {
		return hierarchy_name;
	}



	public void setHierarchy_name(String hierarchy_name) {
		this.hierarchy_name = hierarchy_name;
	}



	public String toString() {
		return String.format("Hierarchy[name='%s']", hierarchy_name);
	}
}
