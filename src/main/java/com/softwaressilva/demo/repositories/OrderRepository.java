package com.softwaressilva.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softwaressilva.demo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
