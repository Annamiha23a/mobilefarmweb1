package com.example.mobilefarmweb.controller;

import com.example.mobilefarmweb.entity.FeedGroup;
import com.example.mobilefarmweb.service.FeedGroupService;
import com.example.mobilefarmweb.service.impl.FeedGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/feedgroups")
public class FeedGroupController {
    private FeedGroupServiceImpl feedGroupService;
    @Autowired
    public FeedGroupController(FeedGroupServiceImpl feedGroupService){
        this.feedGroupService=feedGroupService;
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
}
