package com.example.mobilefarmweb.service.impl;

import com.example.mobilefarmweb.entity.Owner;
import com.example.mobilefarmweb.repository.OwnerRepository;
import com.example.mobilefarmweb.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OwnerServiceImpl implements OwnerService {
    private OwnerRepository ownerRepository;
    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository){
        this.ownerRepository=ownerRepository;
    }
    @Override
    public Owner getOwnersById(Long Id) {
        return ownerRepository.findByOwnerId(Id);
    }
}
