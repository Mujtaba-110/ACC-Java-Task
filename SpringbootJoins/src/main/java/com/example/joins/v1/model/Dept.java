package com.example.joins.v1.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="dept")
public class Dept {
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String description;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(targetEntity = Emp.class, mappedBy = "eid", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Emp> employees;

}
