package com.example.mobilefarmweb.service.impl;

import com.example.mobilefarmweb.entity.*;
import com.example.mobilefarmweb.repository.FarmRepository;
import com.example.mobilefarmweb.repository.LocationRepository;
import com.example.mobilefarmweb.repository.OrganizationRepository;
import com.example.mobilefarmweb.repository.OwnerRepository;
import com.example.mobilefarmweb.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final OrganizationRepository organizationRepository;
    private final OwnerRepository ownerRepository;
    private final AnimalPassportServiceImpl animalPassportService;
    private final LocationRepository locationRepository;

    @Autowired
    public FarmServiceImpl(FarmRepository farmRepository, OrganizationRepository organizationRepository, OwnerRepository ownerRepository, AnimalPassportServiceImpl animalPassportService, LocationRepository locationRepository){
        this.farmRepository = farmRepository;
        this.organizationRepository= organizationRepository;
        this.ownerRepository=ownerRepository;
        this.animalPassportService=animalPassportService;
        this.locationRepository=locationRepository;
    }
    @Override
    public Farm getFarmByGLN(String gln) {
        return farmRepository.findByGln(gln).orElseThrow(()->new NoSuchElementException());
    }

    @Override
    public Farm getFarmByFarmId(Long farmId) {
        return farmRepository.findByFarmId(farmId).orElseThrow(()->new NoSuchElementException());
    }

    @Override
    public List<Farm> getFarmsByOrganizationId(Long organizationId) {
        return farmRepository.findByOrganization_OrganizationId(organizationId);
    }
    @Override
    public List<Farm> getFarmsByOrganizationIdAndName(Long organizationId, String name) {
        if(name!=null)return farmRepository.findByOrganization_OrganizationIdAndNameContaining(organizationId, name);
        return farmRepository.findByOrganization_OrganizationId(organizationId);
    }

    @Override
    public List<Farm> getFarmByName(List<Farm> farms, String name) {
        List<Farm> newFarms = new ArrayList<>();
                for (Farm farm: newFarms){
                    System.out.println(farm.getName().contains(name));
                    if(farm.getName().contains(name))
                    {newFarms.add(farm);
                    System.out.println(farm.getName());}
                }
        return newFarms;
    }


//    @Override
//    public List<Farm> getFarmsByOrganizationId(Long organizationId) {
//        return farmRepository.findByOrganizationId(organizationId);
//    }


    @Override
    public Farm createFarm(Farm farm, Organization organization) {
        farm.setOrganization(organization);
        return farmRepository.save(farm);
    }

//    @Override
//    public Farm updateFarmById(Farm farm, String gln, Long organizationId, Long ownerId) {
//        farm.setGln(gln);
//        Organization organization=organizationRepository.findByOrganizationId(organizationId);
//        farm.setOrganization(organization);
//        Owner owner=ownerRepository.findByOwnerId(ownerId);
//        farm.setOwner(owner);
//        return farmRepository.save(farm);
//    }
//
//    @Override
//    public void deleteFarmById(Long farmId) {
//        farmRepository.deleteByFarmId(farmId);
//    }
@Override
public Farm setFarm(Farm farm,  String gln, String name,  String ownerLastName, String ownerFirstName,  String ownerMiddleName,
                    String locationLocationIndex, String locationRegion,  String locationDistrict, String locationLocationName,  String locationCoordinates,
                    String locationHouseNumber,  String locationCorpusNumber,  String locationFlatNumber,  String locationPhoneNumber,  String locationFaxNumber,
                    String locationEmail, String locationStreetName){
        farm.setGln(gln);
//        farm.setRegistrationDate(registrationDate);
        farm.setName(name);
        Owner owner=new Owner();
        owner.setFirstName(ownerFirstName);
        owner.setLastName(ownerLastName);
        owner.setMiddleName(ownerMiddleName);
        ownerRepository.save(owner);
        farm.setOwner(owner);
        Location location=new Location();
        location.setLocationIndex(locationLocationIndex);
        location.setRegion(locationRegion);
        location.setDistrict(locationDistrict);
        location.setLocationName(locationLocationName);
        location.setCoordinates(locationCoordinates);
        location.setHouseNumber(locationHouseNumber);
        location.setCorpusNumber(locationCorpusNumber);
        location.setFlatNumber(locationFlatNumber);
        location.setPhoneNumber(locationPhoneNumber);
        location.setFaxNumber(locationFaxNumber);
        location.setEmail(locationEmail);
        location.setStreetName(locationStreetName);
        locationRepository.save( location);

        farm.setLocation(location);
//        farmRepository.save(farm);
return farm;
}
}
