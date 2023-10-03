package com.softwaressilva.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.softwaressilva.demo.entities.Product;
import com.softwaressilva.demo.repositories.ProductRepository;
import com.softwaressilva.demo.services.exceptions.DatabaseException;
import com.softwaressilva.demo.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Product insert(Product obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			Product product = findById(id);
			repository.delete(product);	
		} catch(ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Product update(Long id, Product obj) {
		Product entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Product entity, Product obj) {
		entity.setName(obj.getName());
		entity.setDescription(obj.getDescription());
		entity.setPrice(obj.getPrice());
		entity.setImgUrl(obj.getImgUrl());
	}
}
