package com.example.mobilefarmweb.service.impl;

import com.example.mobilefarmweb.entity.FeedGroup;
import com.example.mobilefarmweb.entity.Ration;
import com.example.mobilefarmweb.entity.User;
import com.example.mobilefarmweb.repository.FeedGroupRepository;
import com.example.mobilefarmweb.repository.RationRepository;
import com.example.mobilefarmweb.service.FeedGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeedGroupServiceImpl implements FeedGroupService {
    private FeedGroupRepository feedGroupRepository;
    private RationRepository rationRepository;
    @Autowired
    public void FeedGroupServiceImpl(FeedGroupRepository feedGroupRepository){
        this.feedGroupRepository=feedGroupRepository;
    }
    @Override
    public List<FeedGroup> findAll() {
        return feedGroupRepository.findAll();
    }
    @Override
    public FeedGroup findByFeedGroupId(Long feedgroupId){
        return feedGroupRepository.findByFeedGroupId(feedgroupId);
    }

    @Override
    public List<FeedGroup> filter(Integer m1,Integer m2, Integer w1, Integer w2) {

        List<FeedGroup> list1 = feedGroupRepository.findByProductivityBetweenAndWeightBetween(m1 , m2, w1, w2);

        return list1;
    }
//    @Override
//    public List<FeedGroup> findByRationId(Long rationId){
//        return feedGroupRepository.findByRationId(rationId);
//    }
}
