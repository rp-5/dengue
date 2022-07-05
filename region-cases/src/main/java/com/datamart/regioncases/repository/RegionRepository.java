package com.datamart.regioncases.repository;

import com.datamart.regioncases.entity.Region;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RegionRepository extends CrudRepository<Region, Long> {
    
    @Override
    List<Region> findAll();
}