package com.datamart.humancases.repository;

import org.springframework.data.repository.CrudRepository;

import com.datamart.humancases.entity.Symptom;

public interface SymptomRepository extends CrudRepository<Symptom, Long>{
    
}
