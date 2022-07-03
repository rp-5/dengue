package com.datamart.humancases.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.datamart.humancases.entity.Gravity;
import com.datamart.humancases.repository.GravityRepository;

@Service
public class GravityService {
    
    @Autowired
    private GravityRepository gravityRepository;

    public List<Gravity> getGravityList(){
        Iterable<Gravity> gravityIterable = this.gravityRepository.findAll();
        return Streamable.of(gravityIterable).toList();

    }
}
