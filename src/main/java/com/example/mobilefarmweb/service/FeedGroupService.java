package com.example.mobilefarmweb.service;

import com.example.mobilefarmweb.entity.FeedGroup;
import com.example.mobilefarmweb.entity.Nutrients;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface FeedGroupService {
    List<FeedGroup> findAll();
    FeedGroup findByFeedGroupId(Long feedgroupId);
//    List<FeedGroup> findByRationId(Long rationId);
    List<FeedGroup> filter(Integer m1, Integer m2, Integer w1, Integer w2);
    List<FeedGroup> filter(Integer m1, Integer m2);

    void save(FeedGroup feedGroup, String  type, Integer weight, Integer geneticWeight,  Integer age, Long nutrients_rate_id);

}
