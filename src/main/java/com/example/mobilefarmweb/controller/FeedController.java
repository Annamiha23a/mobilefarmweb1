package com.example.mobilefarmweb.controller;

import com.example.mobilefarmweb.service.impl.FeedGroupServiceImpl;
import com.example.mobilefarmweb.service.impl.FeedServiceImpl;
import com.example.mobilefarmweb.service.impl.NutrientsServiceImpl;
import com.example.mobilefarmweb.service.impl.RationServiceImpl;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FeedController {
    private FeedServiceImpl feedService;
    private FeedGroupServiceImpl feedGroupService;
    @Autowired
    public FeedController(FeedServiceImpl feedService, FeedGroupServiceImpl feedGroupService){
        this.feedService=feedService;
        this.feedGroupService = feedGroupService;
    }
    @GetMapping("/feeding")
    public String getRations(){
        return "admin/ration2";

    }

    @GetMapping("/feedration")
    public String getFeedRations(Model model){
        model.addAttribute("feeds", feedService.getAll());
        model.addAttribute("feedgroups", feedGroupService.findAll() );
        return "admin/feedration";

    }
}
