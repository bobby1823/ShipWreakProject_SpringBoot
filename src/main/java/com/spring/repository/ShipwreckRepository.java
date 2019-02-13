package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}
