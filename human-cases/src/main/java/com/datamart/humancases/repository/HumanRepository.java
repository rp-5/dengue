package com.datamart.humancases.repository;

import com.datamart.humancases.entity.Human;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepository extends JpaRepository<Human, Long> {
    
    @Override
    List<Human> findAll();

    Human findById(long id);
}