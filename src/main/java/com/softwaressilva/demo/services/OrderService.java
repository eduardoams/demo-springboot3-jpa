package com.softwaressilva.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.softwaressilva.demo.entities.Order;
import com.softwaressilva.demo.repositories.OrderRepository;
import com.softwaressilva.demo.services.exceptions.DatabaseException;
import com.softwaressilva.demo.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Order insert(Order obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			Order order = findById(id);
			repository.delete(order);	
		} catch(ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
