package com.example.mobilefarmweb.repository;

import com.example.mobilefarmweb.entity.Farm;
import com.example.mobilefarmweb.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Long> {
    @Query("SELECT feed FROM Feed feed\n" +
            "INNER JOIN RationFeeds rf ON feed.feedId = rf.ration.rationId\n" +
            "INNER JOIN Ration  r ON rf.ration.rationId = r.rationId\n" +
            "INNER JOIN FeedGroup g ON r.feedGroup.feedGroupId = g.feedGroupId\n" +
            "INNER JOIN AnimalPassport a ON g.feedGroupId = a.feedGroup.feedGroupId\n" +
            "INNER JOIN Farm f ON a.farm.farmId = f.farmId\n" +
            "WHERE f.organization.name = ?1")
    List<Feed> findByOrganizationName(String organization);

    Optional<Feed> findByFeedId(Long FeedId);
}
