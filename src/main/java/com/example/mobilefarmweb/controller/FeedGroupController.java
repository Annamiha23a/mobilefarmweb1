package com.example.mobilefarmweb.controller;

import com.example.mobilefarmweb.entity.FeedGroup;
import com.example.mobilefarmweb.entity.Nutrients;
import com.example.mobilefarmweb.excel.Read;
import com.example.mobilefarmweb.excel.Reselv;
import com.example.mobilefarmweb.service.FeedGroupService;
import com.example.mobilefarmweb.service.impl.FeedGroupServiceImpl;
import com.example.mobilefarmweb.service.impl.NutrientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping(value = "/feedgroups")
public class FeedGroupController {
    private FeedGroupServiceImpl feedGroupService;
    private NutrientsServiceImpl nutrientsService;
    @Autowired
    public FeedGroupController(FeedGroupServiceImpl feedGroupService, NutrientsServiceImpl nutrientsService){
        this.feedGroupService=feedGroupService;
        this.nutrientsService=nutrientsService;
    }
    @GetMapping()
    public String getAllFeedGroups(Model model){
        List<FeedGroup> feedgroups = feedGroupService.findAll();
        model.addAttribute("feedgroups", feedgroups);
        return "admin/feedgroups";
    }

    @GetMapping("/{id}")
    public String getFeedgroupsDetails(Model model, @PathVariable("id") Long id ){
        FeedGroup feedGroup=feedGroupService.findByFeedGroupId(id);
        model.addAttribute("feedGroup", feedGroup);
        return "admin/feedgroups-details";
    }

    @GetMapping("/filter")
    public String filter(Model model, @RequestParam(name="milk1", required = false) Integer milk1, @RequestParam(name="milk2", required = false) Integer milk2, @RequestParam(name="weight1", required = false) Integer weight1, @RequestParam(name="weight2", required = false) Integer weight2){
        List<FeedGroup> feedgroups = feedGroupService.filter(milk1, milk2, weight1, weight2);
        model.addAttribute("feedgroups", feedgroups);
        return "admin/feedgroups";
    }

    @GetMapping("/add")
    public String addFeedGroup(Model model){
        model.addAttribute("nutrients",nutrientsService.getAllNutrients());
        return "admin/feedGroupAdd";
    }

    @PostMapping("/add")
    public String saveFeedGroup(Model model, FeedGroup feedGroup, @RequestParam(name="type", required = false) String  type, @RequestParam(name="weight", required = false) Integer weight, @RequestParam(name="geneticWeight", required = false) Integer geneticWeight, @RequestParam(name="age", required = false) Integer age, @RequestParam BigDecimal feedUnit, @RequestParam BigDecimal energyExchange, @RequestParam BigDecimal dryMatter, @RequestParam BigDecimal dryProtein, @RequestParam BigDecimal digestedProtein, @RequestParam BigDecimal rawFat, @RequestParam BigDecimal rawFiber, @RequestParam BigDecimal starch, @RequestParam BigDecimal sugar, @RequestParam BigDecimal lysine, @RequestParam BigDecimal methionineAndCystitis, @RequestParam BigDecimal calcium, @RequestParam BigDecimal phosphorus, @RequestParam BigDecimal magnesium, @RequestParam BigDecimal potassium, @RequestParam BigDecimal sulfur, @RequestParam BigDecimal ferrum, @RequestParam BigDecimal copper, @RequestParam BigDecimal zins, @RequestParam BigDecimal manganese, @RequestParam BigDecimal cobalt, @RequestParam BigDecimal iodine, @RequestParam  BigDecimal carotene, @RequestParam BigDecimal vitaminE, @RequestParam BigDecimal vitaminD ){
        Nutrients nutrients=nutrientsService.saveNutrient(feedUnit, energyExchange, dryMatter, dryProtein, digestedProtein, rawFat, rawFiber, starch, sugar, lysine, methionineAndCystitis, calcium, phosphorus, magnesium, potassium, sulfur, ferrum, copper, zins, manganese, cobalt, iodine, carotene, vitaminE, vitaminD);
        feedGroupService.save(feedGroup, type, weight, geneticWeight, age, nutrients.getNutrientsId());
        List<FeedGroup> feedgroups = feedGroupService.findAll();
        model.addAttribute("feedgroups", feedgroups);
        return "admin/feedgroups";
    }



}
