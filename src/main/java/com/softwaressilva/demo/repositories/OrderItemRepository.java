package com.softwaressilva.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softwaressilva.demo.entities.OrderItem;
import com.softwaressilva.demo.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
