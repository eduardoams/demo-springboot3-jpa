package com.softwaressilva.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softwaressilva.demo.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
