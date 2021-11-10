package com.event.management.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "category")
@Table(name = "category")
public class Category {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	
	/*@JsonIgnore
	@OneToOne(mappedBy = "category", cascade = CascadeType.REMOVE)
	private Event event;*/
	
}
