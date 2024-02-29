package com.example.mobilefarmweb.service.impl;

import com.example.mobilefarmweb.entity.Role;
import com.example.mobilefarmweb.repository.RoleRepository;
import com.example.mobilefarmweb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    @Override
    public Role findRoleById(Integer id) {
        return roleRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }
}
