package com.example.mobilefarmweb.service.impl;

import com.example.mobilefarmweb.entity.Farm;
import com.example.mobilefarmweb.entity.Organization;
import com.example.mobilefarmweb.entity.Owner;
import com.example.mobilefarmweb.repository.FarmRepository;
import com.example.mobilefarmweb.repository.OrganizationRepository;
import com.example.mobilefarmweb.repository.OwnerRepository;
import com.example.mobilefarmweb.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final OrganizationRepository organizationRepository;
    private final OwnerRepository ownerRepository;

    @Autowired
    public FarmServiceImpl(FarmRepository farmRepository, OrganizationRepository organizationRepository, OwnerRepository ownerRepository){
        this.farmRepository = farmRepository;
        this.organizationRepository= organizationRepository;
        this.ownerRepository=ownerRepository;
    }
    @Override
    public Farm getFarmByGLN(String gln) {
        return farmRepository.findByGln(gln).orElseThrow(()->new NoSuchElementException());
    }

    @Override
    public List<Farm> getFarmsByOrganizationId(Long organizationId) {
        return farmRepository.findByOrganization_OrganizationId(organizationId);
    }

//    @Override
//    public List<Farm> getFarmsByOrganizationId(Long organizationId) {
//        return farmRepository.findByOrganizationId(organizationId);
//    }


//    @Override
//    public Farm createFarm(Farm farm, Long organizationId) {
//        return farmRepository.save(farm);
//    }

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
}
