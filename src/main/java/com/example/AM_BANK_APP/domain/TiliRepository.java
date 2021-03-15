package com.example.AM_BANK_APP.domain;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface TiliRepository extends JpaRepository <Tili, Long> {

	 
}
