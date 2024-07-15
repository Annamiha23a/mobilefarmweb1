package com.example.mobilefarmweb.service.impl;

import com.example.mobilefarmweb.entity.*;
import com.example.mobilefarmweb.repository.RationFeedsRepository;
import com.example.mobilefarmweb.repository.RationRepository;
import com.example.mobilefarmweb.service.RationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class RationServiceImpl implements RationService {
    private RationRepository rationRepository;
    private RationFeedsRepository rationFeedsRepository;

    @Autowired
    public RationServiceImpl(RationRepository rationRepository, RationFeedsRepository rationFeedsRepository){
        this.rationRepository=rationRepository;
        this.rationFeedsRepository= rationFeedsRepository;
    }
    @Override
    public List<Ration> getAll() {
        return rationRepository.findAll();
    }

    @Override
    public Ration getRationById(Long id) {
        return rationRepository.findRationByRationId(id);
    }

    @Override
    public void saveRation(String title, FeedGroup feedGroup, List<Feed> feeds, List<BigDecimal> kg) {
        List<RationFeeds> list=new ArrayList<>();
        Ration ration =new Ration();
        ration.setFeedGroup(feedGroup);
        ration.setTitle(title);
        int i=0, j=0;
        for(Feed feed:feeds){
            j = 0; // Сброс значения j при каждом новом проходе внешнего цикла
            for(BigDecimal k:kg){
                if(i==j){
                    RationFeeds rationFeeds= new RationFeeds();
                    rationFeeds.setRation(ration);
                    rationFeeds.setFeed(feed);
                    rationFeeds.setAmount(k);
//                    RationFeedKey rationFeedKey=new RationFeedKey();
//                    rationFeedKey.setRationId(ration.getRationId());
                    list.add(rationFeeds);
                    System.out.println(rationFeeds);
                }
                j++;
            }
            i++;
        }
        ration.setRationFeeds(list);
        Ration rationSave= rationRepository.save(ration);
        for(RationFeeds rationFeeds: list){
            RationFeedKey rationFeedKey=new RationFeedKey();
            rationFeedKey.setRationId(rationSave.getRationId().longValue());
            rationFeedKey.setFeedId(rationFeeds.getFeed().getFeedId());
            rationFeeds.setId(rationFeedKey);
            rationFeedsRepository.save(rationFeeds);
        }
    }

    @Override
    public void deleteRations(Ration ration) {
        for(RationFeeds rationFeed: ration.getRationFeeds()){
        rationFeedsRepository.delete(rationFeed);}
        rationRepository.delete(ration);
    }


}
