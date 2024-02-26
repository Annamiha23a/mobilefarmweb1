package com.example.mobilefarmweb.service.impl;

import com.example.mobilefarmweb.entity.Organization;
import com.example.mobilefarmweb.repository.OrganizationRepository;
import com.example.mobilefarmweb.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;
    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository){
        this.organizationRepository = organizationRepository;
    }
//    @Override
//    public Organization getOrganizationByGLN(String gln) {
//        return organizationStorage.getOrganizationByGLN(gln);
//    }

    @Override
    public Organization getOrganizationByUNP(String unp) {
        return organizationRepository.findByUnp(unp);
    }

//    @Override
//    public Organization createOrganization(Organization organization) {
//        return organizationStorage.createOrganization(organization);
//    }
//
//    @Override
//    public void deleteOrganizationById(Long organizationId) {
//        organizationStorage.deleteOrganizationById(organizationId);
//    }
}
