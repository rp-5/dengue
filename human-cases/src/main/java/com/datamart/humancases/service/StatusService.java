package com.datamart.humancases.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.datamart.humancases.entity.Status;
import com.datamart.humancases.repository.StatusRepository;

@Service
public class StatusService {
    
    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getStatusList(){
        Iterable<Status> statusIterable = this.statusRepository.findAll();
        return Streamable.of(statusIterable).toList();
    }
}
