package com.datamart.humancases.service;

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
}
