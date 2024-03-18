package com.example.mobilefarmweb.service;

import com.example.mobilefarmweb.entity.Feed;

import java.util.List;

public interface FeedService {
    List<Feed> getAll();
    Feed createFeed(Feed feed);
    void deleteFeedById(Long feedId);
    List<Feed> findByOrganizationName(String organization);
}
