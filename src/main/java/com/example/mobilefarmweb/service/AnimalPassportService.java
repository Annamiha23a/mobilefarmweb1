package com.example.mobilefarmweb.service;

import com.example.mobilefarmweb.entity.AnimalPassport;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface AnimalPassportService {
  List<AnimalPassport> getAllAnimals();
  List<AnimalPassport> getAnimalByFarm(Long farm_id);
  List<AnimalPassport> getAnimalPassportsByOrganizationId(Long OrganizationId);

  List<AnimalPassport> getAnimalPassportsByOrganizationIdAndExternalId(Long OrganizationId, String externalId);

  AnimalPassport getAnimalPassportByExternalId(String externalId);

  AnimalPassport saveAnimalPassport(AnimalPassport animalPassport, String externalId, String nickname, String type, String sex, String breed, Boolean breedingAnimal, BigDecimal weight, BigDecimal averageProductivity, BigDecimal geneticProductivity, BigDecimal weightGrowth, String mother, String father, Long farm_id);
}
