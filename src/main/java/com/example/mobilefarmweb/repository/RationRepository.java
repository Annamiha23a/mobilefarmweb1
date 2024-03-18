package com.example.mobilefarmweb.repository;

import com.example.mobilefarmweb.entity.Ration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RationRepository extends JpaRepository<Ration, Long> {
    @Query("SELECT r.rationId FROM Ration r\n" +
            "INNER JOIN FeedGroup g ON r.feedGroup.feedGroupId = g.feedGroupId\n" +
            "INNER JOIN AnimalPassport a ON g.feedGroupId = a.feedGroup.feedGroupId\n" +
            "INNER JOIN Farm f ON a.farm.farmId = f.farmId\n" +
            "WHERE f.organization.name = ?1")
    List<Integer> findByOrganizationName(String organization);
}
