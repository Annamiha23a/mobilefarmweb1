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
    public void  updateRation(Long id, String title, FeedGroup feedGroup, List<Feed> feeds, List<BigDecimal> kg) {
        // Получаем сущность Ration по её ID
        Ration ration = rationRepository.findRationByRationId(id);

        if (ration == null) {
            throw new IllegalArgumentException("Ration not found for the given ID: " + id);
        }

        // Обновляем название и группу кормов (FeedGroup) у рациона
        ration.setFeedGroup(feedGroup);
        ration.setTitle(title);

        // Удаляем старые записи RationFeeds
        List<RationFeeds> rationFeedsList = ration.getRationFeeds();
        if (rationFeedsList != null) {
            rationFeedsRepository.deleteAll(rationFeedsList);
            rationFeedsList.clear();
        } else {
            rationFeedsList = new ArrayList<>();
            ration.setRationFeeds(rationFeedsList);
        }

        // Создаем и добавляем новые записи RationFeeds
        for (int i = 0; i < feeds.size(); i++) {
            Feed feed = feeds.get(i);
            BigDecimal amount = kg.get(i);

            // Проверяем, что объекты Feed и amount не равны null
            if (feed == null || amount == null) {
                throw new IllegalArgumentException("Feed or amount cannot be null");
            }

            RationFeeds rationFeeds = new RationFeeds();
            rationFeeds.setRation(ration);
            rationFeeds.setFeed(feed);
            rationFeeds.setAmount(amount);

            // Создаем составной ключ и устанавливаем его в RationFeeds
            RationFeedKey rationFeedKey = new RationFeedKey();
            rationFeedKey.setRationId(ration.getRationId());
            rationFeedKey.setFeedId(feed.getFeedId());
            rationFeeds.setId(rationFeedKey);

            // Сохраняем запись RationFeeds в репозитории
            rationFeedsRepository.save(rationFeeds);

            // Добавляем новую запись в список
            rationFeedsList.add(rationFeeds);
        }

        // Обновляем сущность Ration и сохраняем её
        rationRepository.save(ration);
    }

    @Override
    public void deleteRations(Ration ration) {
        for(RationFeeds rationFeed: ration.getRationFeeds()){
        rationFeedsRepository.delete(rationFeed);}
        rationRepository.delete(ration);
    }


}
