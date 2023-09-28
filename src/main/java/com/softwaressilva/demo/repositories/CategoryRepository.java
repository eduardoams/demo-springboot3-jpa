package com.softwaressilva.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softwaressilva.demo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
