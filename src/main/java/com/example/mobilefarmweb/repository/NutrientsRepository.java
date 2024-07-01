package com.example.mobilefarmweb.repository;

import com.example.mobilefarmweb.entity.Nutrients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NutrientsRepository extends JpaRepository<Nutrients, Long> {
    Optional<Nutrients> findByNutrientsId(Long nutrientsId);
    List<Nutrients> findAll();
}
