package com.datamart.humancases.repository;

import com.datamart.humancases.entity.Human;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HumanRepository extends CrudRepository<Human, Long> {
    
    @Override
    List<Human> findAll();
}