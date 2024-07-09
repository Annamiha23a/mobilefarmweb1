package com.example.mobilefarmweb.repository;

import com.example.mobilefarmweb.entity.Ration;
import com.example.mobilefarmweb.entity.RationFeeds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RationFeedsRepository extends JpaRepository<RationFeeds, Long> {
}
