package com.example.mobilefarmweb.service;

import com.example.mobilefarmweb.entity.FeedGroup;

import java.util.List;

public interface FeedGroupService {
    List<FeedGroup> findAll();
    FeedGroup findByFeedGroupId(Long feedgroupId);
//    List<FeedGroup> findByRationId(Long rationId);
}
