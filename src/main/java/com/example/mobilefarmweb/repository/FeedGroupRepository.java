package com.example.mobilefarmweb.repository;

import com.example.mobilefarmweb.entity.FeedGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FeedGroupRepository extends JpaRepository<FeedGroup, Long> {
    FeedGroup findByTypeAndProductivityAndWeightAndGeneticWeightAndAge(String type, BigDecimal productivity, BigDecimal weight, BigDecimal geneticWeight, Integer age);

    //SELECT * FROM feedGroups WHERE organization_id = 'ID_Вашей_Организации';
    @Query("SELECT o FROM FeedGroup o\n" +
            "INNER JOIN AnimalPassport a ON o.feedGroupId = a.feedGroup.feedGroupId\n" +
            "INNER JOIN Farm f ON a.farm.farmId = f.farmId\n" +
            "WHERE f.organization.organizationId = ?1")
    List<FeedGroup> findByOrganizationName(Long organizationId);

    List<FeedGroup> findAll();

    FeedGroup findByFeedGroupId(Long feedgroupId);
//    List<FeedGroup> findByRationId(Long rationId);
}
