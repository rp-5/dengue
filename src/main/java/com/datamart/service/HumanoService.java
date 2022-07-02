package com.datamart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datamart.entity.Humano;
import com.datamart.repository.HumanoRepository;

@Service
public class HumanoService {
    
    @Autowired
    private HumanoRepository humanoRepository;

    public void save(Humano humano){
        this.humanoRepository.save(humano);
    }
}
