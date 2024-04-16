package com.example.mobilefarmweb.service.impl;

import com.example.mobilefarmweb.entity.AnimalPassport;
import com.example.mobilefarmweb.repository.AnimalPassportRepository;
import com.example.mobilefarmweb.repository.FarmRepository;
import com.example.mobilefarmweb.service.AnimalPassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AnimalPassportServiceImpl implements AnimalPassportService {
    private final AnimalPassportRepository animalPassportRepository;
    private final FarmRepository farmRepository;
    @Autowired
    public AnimalPassportServiceImpl (AnimalPassportRepository animalPassportRepository, FarmRepository farmRepository){
       this.animalPassportRepository=animalPassportRepository;
       this.farmRepository=farmRepository;
    }
    @Override
    public List<AnimalPassport> getAllAnimals() {
        return animalPassportRepository.findAll();
    }

    @Override
    public List<AnimalPassport> getAnimalByFarm(Long farm_id) {
        return animalPassportRepository.findByFarm_FarmId(farm_id);
    }
    @Override
    public List<AnimalPassport> getAnimalPassportsByOrganizationId(Long OrganizationId) {
        return animalPassportRepository.findByOrganizationId(OrganizationId);
    }

    @Override
    public List<AnimalPassport> getAnimalPassportsByOrganizationIdAndExternalId(Long organizationId, String externalId) {
        if(externalId!=null)return animalPassportRepository.findByOrganizationIdAndExternalIdContaining(organizationId, externalId);
        return animalPassportRepository.findByOrganizationId(organizationId);
    }

    @Override
    public AnimalPassport getAnimalPassportByExternalId(String externalId) {
        return animalPassportRepository.findByExternalId(externalId).orElseThrow(()->new NoSuchElementException());
    }

    @Override
    public AnimalPassport saveAnimalPassport(AnimalPassport animalPassport, String externalId,  String nickname,String type, String sex, String breed, Boolean breedingAnimal,OffsetDateTime birthDate,  BigDecimal weight, BigDecimal averageProductivity, BigDecimal geneticProductivity, BigDecimal weightGrowth, String mother, String father, Long farm_id) {
        animalPassport.setExternalId(externalId);
        animalPassport.setCreatedDate(OffsetDateTime.now());//TODO
        animalPassport.setNickname(nickname);
        animalPassport.setType(type);
        animalPassport.setSex(sex);
        animalPassport.setBreed(breed);
        animalPassport.setBreedingAnimal(breedingAnimal);
        animalPassport.setBirthDate(birthDate);
        animalPassport.setWeight(weight);
        animalPassport.setAverageProductivity(averageProductivity);
        animalPassport.setGeneticProductivity(geneticProductivity);
        animalPassport.setWeightGrowth(weightGrowth);
//        AnimalPassport motherA=animalPassportRepository.findByExternalId(mother).orElseThrow(()->new NoSuchElementException());
//        animalPassport.setMother(motherA); //TODO
//        AnimalPassport fatherA=animalPassportRepository.findByExternalId(father).orElseThrow(()->new NoSuchElementException());
//        animalPassport.setFather(fatherA);
        animalPassport.setFarm(farmRepository.findByFarmId(farm_id).orElseThrow(()->new NoSuchElementException()));
        return animalPassportRepository.save(animalPassport);
    }
}
