package com.example.mobilefarmweb.service.impl;

import com.example.mobilefarmweb.entity.Nutrients;
import com.example.mobilefarmweb.repository.NutrientsRepository;
import com.example.mobilefarmweb.service.NutrientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NutrientsServiceImpl implements NutrientsService {
    private NutrientsRepository nutrientsRepository;
    @Autowired
    public NutrientsServiceImpl(NutrientsRepository nutrientsRepository){
        this.nutrientsRepository=nutrientsRepository;
    }

    @Override
    public Nutrients getNutrientsById(Long nutrients_id) {
        return nutrientsRepository.findByNutrientsId(nutrients_id).orElseThrow(()->new NoSuchElementException());
    }

    @Override
    public List<Nutrients> getAllNutrients() {
        return nutrientsRepository.findAll();
    }
}
