package com.datamart.humancases.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datamart.humancases.entity.Human;
import com.datamart.humancases.repository.HumanRepository;

@Service
public class HumanService {
    @Autowired
    private HumanRepository humanRepository;

    public void save(Human human) {
        this.humanRepository.save(human);
    }

    public List<Human> findAll(){
        return this.humanRepository.findAll();
    }

    public Human findById(Long id){
        return this.humanRepository.findById(id).get();
    }
}
