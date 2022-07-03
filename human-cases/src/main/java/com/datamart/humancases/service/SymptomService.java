package com.datamart.humancases.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import com.datamart.humancases.entity.Symptom;
import com.datamart.humancases.repository.SymptomRepository;
@Service
public class SymptomService {
    
    @Autowired
    private SymptomRepository symptomRepository;

    public List<Symptom> getSymptomList(){
        Iterable<Symptom> symptomIterable = this.symptomRepository.findAll();
        return Streamable.of(symptomIterable).toList();
    }
}
