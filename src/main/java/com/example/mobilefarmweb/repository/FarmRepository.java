package com.example.mobilefarmweb.repository;

import com.example.mobilefarmweb.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
    Optional<Farm> findByGln(String gln);
    Optional<Farm> findByFarmId(Long farmId);

    List<Farm> findByOrganization_OrganizationId(Long organizationId);
    List<Farm> findByOrganization_OrganizationIdAndNameContaining(Long organizationId, String name);
    Void deleteByFarmId(Long id);

}