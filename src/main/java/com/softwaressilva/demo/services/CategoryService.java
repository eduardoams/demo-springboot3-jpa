package com.softwaressilva.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.softwaressilva.demo.entities.Category;
import com.softwaressilva.demo.entities.User;
import com.softwaressilva.demo.repositories.CategoryRepository;
import com.softwaressilva.demo.services.exceptions.DatabaseException;
import com.softwaressilva.demo.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Category insert(Category obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			Category category = findById(id);
			repository.delete(category);	
		} catch(ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Category update(Long id, Category obj) {
		Category entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Category entity, Category obj) {
		entity.setName(obj.getName());	
	}
}
