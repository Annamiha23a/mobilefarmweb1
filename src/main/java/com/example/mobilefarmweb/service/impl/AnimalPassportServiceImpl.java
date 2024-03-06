package com.example.mobilefarmweb.service.impl;

import com.example.mobilefarmweb.entity.AnimalPassport;
import com.example.mobilefarmweb.repository.AnimalPassportRepository;
import com.example.mobilefarmweb.repository.FarmRepository;
import com.example.mobilefarmweb.repository.OrganizationRepository;
import com.example.mobilefarmweb.repository.OwnerRepository;
import com.example.mobilefarmweb.service.AnimalPassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalPassportServiceImpl implements AnimalPassportService {
    private final AnimalPassportRepository animalPassportRepository;
    @Autowired
    public AnimalPassportServiceImpl (AnimalPassportRepository animalPassportRepository){
       this.animalPassportRepository=animalPassportRepository;
    }
    @Override
    public List<AnimalPassport> getAllAnimals() {
        return animalPassportRepository.findAll();
    }

    @Override
    public List<AnimalPassport> getAnimalByFarm(Long farm_id) {
        return animalPassportRepository.findByFarm_FarmId(farm_id);
    }
}
