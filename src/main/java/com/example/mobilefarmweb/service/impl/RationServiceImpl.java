package com.example.mobilefarmweb.service.impl;

import com.example.mobilefarmweb.entity.Ration;
import com.example.mobilefarmweb.repository.RationRepository;
import com.example.mobilefarmweb.service.RationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RationServiceImpl implements RationService {
    private RationRepository rationRepository;
    @Autowired
    public RationServiceImpl(RationRepository rationRepository){
        this.rationRepository=rationRepository;
    }
    @Override
    public List<Ration> getAll() {
        return rationRepository.findAll();
    }
}
