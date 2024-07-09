package com.example.mobilefarmweb.service.impl;

import com.example.mobilefarmweb.entity.Feed;
import com.example.mobilefarmweb.repository.FeedRepository;
import com.example.mobilefarmweb.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class FeedServiceImpl implements FeedService {
   private FeedRepository feedRepository;
    @Autowired
   public void FeedServiceImpl (FeedRepository feedRepository){
       this.feedRepository=feedRepository;
   }
    @Override
    public List<Feed> getAll() {
        return feedRepository.findAll();
    }

    public Feed findbyId(Long id) {
        return feedRepository.findByFeedId(id).orElseThrow(()->new NoSuchElementException());
    }

    @Override
    public Feed createFeed(Feed feed) {
        return feedRepository.save(feed);
    }

    @Override
    public void deleteFeedById(Long feedId) {
        Feed feed=feedRepository.findByFeedId(feedId).orElseThrow(()->new NoSuchElementException());
        feedRepository.delete(feed);
    }

    @Override
    public List<Feed> findByOrganizationName(String organization) {
        return feedRepository.findByOrganizationName(organization);
    }
}
