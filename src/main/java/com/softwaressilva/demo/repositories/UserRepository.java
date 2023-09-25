package com.softwaressilva.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softwaressilva.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
