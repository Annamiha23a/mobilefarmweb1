package com.example.mobilefarmweb.service;

import com.example.mobilefarmweb.entity.AnimalPassport;

import java.util.List;

public interface AnimalPassportService {
  List<AnimalPassport> getAllAnimals();
  List<AnimalPassport> getAnimalByFarm(Long farm_id);
  List<AnimalPassport> getAnimalPassportsByOrganizationId(Long OrganizationId);

  List<AnimalPassport> getAnimalPassportsByOrganizationIdAndExternalId(Long OrganizationId, String externalId);

  AnimalPassport getAnimalPassportByExternalId(String externalId);

}
