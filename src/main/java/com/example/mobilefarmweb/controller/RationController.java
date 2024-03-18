package com.example.mobilefarmweb.controller;

import com.example.mobilefarmweb.entity.*;
import com.example.mobilefarmweb.service.impl.FeedServiceImpl;
import com.example.mobilefarmweb.service.impl.NutrientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/rations")
public class RationController {
    private FeedServiceImpl feedService;
    private NutrientsServiceImpl nutrientsService;
    @Autowired
    public RationController(FeedServiceImpl feedService, NutrientsServiceImpl nutrientsService){
        this.feedService=feedService;
        this.nutrientsService=nutrientsService;
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
}
