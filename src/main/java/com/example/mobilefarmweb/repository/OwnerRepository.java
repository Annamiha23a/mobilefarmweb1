package com.example.mobilefarmweb.repository;

import com.example.mobilefarmweb.entity.Farm;
import com.example.mobilefarmweb.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByOwnerId(Long Id);
}
