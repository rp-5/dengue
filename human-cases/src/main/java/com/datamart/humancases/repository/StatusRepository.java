package com.datamart.humancases.repository;

import org.springframework.data.repository.CrudRepository;

import com.datamart.humancases.entity.Status;

public interface StatusRepository extends CrudRepository<Status, Long>{
    
}
