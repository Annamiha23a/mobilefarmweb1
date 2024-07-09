package com.example.mobilefarmweb.service;

import com.example.mobilefarmweb.entity.Feed;
import com.example.mobilefarmweb.entity.FeedGroup;
import com.example.mobilefarmweb.entity.Ration;

import java.math.BigDecimal;
import java.util.List;

public interface RationService {
    List<Ration> getAll();

    void saveRation(FeedGroup feedGroup, List<Feed> feeds, List<BigDecimal> kg);
}
