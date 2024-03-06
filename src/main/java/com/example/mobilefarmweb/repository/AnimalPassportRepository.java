package com.example.mobilefarmweb.repository;

import com.example.mobilefarmweb.entity.AnimalPassport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalPassportRepository extends JpaRepository<AnimalPassport, Long> {
    Optional<AnimalPassport> findByExternalId(String externalId);
    List<AnimalPassport> findByFarm_FarmId(Long farmId);

    @Query("SELECT ap FROM Organization o\n" +
            "INNER JOIN Farm f ON o.organizationId = f.organization.organizationId\n" +
            "INNER JOIN AnimalPassport ap ON f.farmId = ap.farm.farmId\n" +
            "WHERE o.organizationId = ?1")
    List<AnimalPassport> findByOrganizationId(Long organizationId);
}
