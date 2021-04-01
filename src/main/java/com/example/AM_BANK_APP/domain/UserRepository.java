package com.example.AM_BANK_APP.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {
	
	User findByUsername(String username);


}
