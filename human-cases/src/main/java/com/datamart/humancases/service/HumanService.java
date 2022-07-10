package com.datamart.humancases.service;

import java.util.List;
import java.util.Optional;

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

    public void edit(Long id, Human oldHuman){
        Human human = humanRepository.getById(id);
        // if(){
        // human.setName(oldHuman.getName());
        // human.setAge(oldHuman.getAge());
        // human.setAdress(oldHuman.getAdress());
        // human.setComplement(oldHuman.getComplement());
        // human.setSymptom(oldHuman.getSymptom());
        // human.setGravity(oldHuman.getGravity());
        // human.setStatus(oldHuman.getStatus());
        // humanRepository.save(human);
        // }
    }

    public List<Human> findAll(){
        return this.humanRepository.findAll();
    }

    public Human findById(Long id){
        return this.humanRepository.findById(id).get();
    }

    public void delete(Long id){
        this.humanRepository.deleteById(id);
    }
}
