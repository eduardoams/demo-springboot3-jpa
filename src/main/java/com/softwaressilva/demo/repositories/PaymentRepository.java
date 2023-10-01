package com.softwaressilva.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softwaressilva.demo.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
