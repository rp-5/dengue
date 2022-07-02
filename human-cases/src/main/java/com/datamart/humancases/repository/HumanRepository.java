package com.datamart.humancases.repository;

import com.datamart.humancases.entity.Human;
import org.springframework.data.repository.CrudRepository;

public interface HumanRepository extends CrudRepository<Human, Long> {
    
}