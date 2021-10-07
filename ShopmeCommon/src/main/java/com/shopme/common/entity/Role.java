package com.shopme.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Khaled Reza, Email:khaledreza@gmail.com
 */
@Data
@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 40, nullable = false, unique = true)
	private String name;

	@Column(length = 150, nullable = false)
	private String description;
	
	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public Role(String name, String description) {
		this.name = name;
		this.description = description;
	}

}
