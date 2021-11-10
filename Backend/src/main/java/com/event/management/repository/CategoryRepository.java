package com.event.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.management.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
