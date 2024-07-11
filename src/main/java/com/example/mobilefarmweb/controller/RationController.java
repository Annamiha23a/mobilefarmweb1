package com.example.mobilefarmweb.controller;

import com.example.mobilefarmweb.entity.*;
import com.example.mobilefarmweb.service.RationService;
import com.example.mobilefarmweb.service.impl.FeedGroupServiceImpl;
import com.example.mobilefarmweb.service.impl.FeedServiceImpl;
import com.example.mobilefarmweb.service.impl.NutrientsServiceImpl;
import com.example.mobilefarmweb.service.impl.RationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/rations")
public class RationController {
    private RationServiceImpl rationService;
    private FeedServiceImpl feedService;
    private NutrientsServiceImpl nutrientsService;
    private FeedGroupServiceImpl feedGroupService;
    @Autowired
    public RationController(FeedServiceImpl feedService, NutrientsServiceImpl nutrientsService, RationServiceImpl rationService, FeedGroupServiceImpl feedGroupService){
        this.feedService=feedService;
        this.nutrientsService=nutrientsService;
        this.rationService=rationService;
        this.feedGroupService=feedGroupService;
    }
    @GetMapping()
    public String getRations(){
        return "admin/ration1";

    }
    @GetMapping("/feeds")
    public String getFeeds(Model model){
        List<Feed> feeds=feedService.getAll();
        model.addAttribute("feeds", feeds);
        return "admin/feeds";

    }
    @GetMapping("/feeds/{id}")
    public String getNutrientsFeeds(Model model, @PathVariable("id") Long id){
        Nutrients nutrient=nutrientsService.getNutrientsById(id);
        model.addAttribute("nutrient", nutrient);
        return "admin/nutrient";

    }
    @GetMapping("/all")
    public String getAllRations(Model model){
        List<Ration> rations=rationService.getAll();
        model.addAttribute("rations", rations);
        return "admin/rations";

    }
    @PostMapping("/save")
    public String saveRations(Model model, @RequestParam(name="title") String  title, @RequestParam(name="kg") List<BigDecimal>  kg, @RequestParam(name="feed") List<Long>  feed, @RequestParam(name="feedGroup") Long  feedGroup){
        System.out.println("Успешно сохранено "+ title + kg + feed + feedGroup);
        FeedGroup feedGroup1=feedGroupService.findByFeedGroupId(feedGroup);
        List<Feed> feeds = new ArrayList<>();
        for(Long f:feed){
            Feed feed1=feedService.findbyId(f);
            feeds.add(feed1);
        }
        rationService.saveRation(title, feedGroup1, feeds, kg );
        return "admin/rations";
    }

    @PostMapping("/excel")
    public String excelAllRations(){
       System.out.println("Запись в ексель");
        return "admin/rations";
    }

}
