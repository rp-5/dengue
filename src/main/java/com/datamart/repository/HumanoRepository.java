package com.datamart.repository;

import com.datamart.entity.Humano;

import org.springframework.data.repository.CrudRepository;

public interface HumanoRepository extends CrudRepository<Humano, Long> {
    
}
