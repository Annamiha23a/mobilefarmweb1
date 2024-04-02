package com.example.mobilefarmweb.controller;

import com.example.mobilefarmweb.service.impl.FeedServiceImpl;
import com.example.mobilefarmweb.service.impl.NutrientsServiceImpl;
import com.example.mobilefarmweb.service.impl.RationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FeedController {
    private FeedServiceImpl feedService;
    @Autowired
    public FeedController(FeedServiceImpl feedService){
        this.feedService=feedService;
    }
    @GetMapping("/feeding")
    public String getRations(){
        return "admin/ration2";

    }
}
