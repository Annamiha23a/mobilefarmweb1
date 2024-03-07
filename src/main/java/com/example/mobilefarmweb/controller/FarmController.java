package com.example.mobilefarmweb.controller;

import com.example.mobilefarmweb.entity.Farm;
import com.example.mobilefarmweb.entity.Organization;
import com.example.mobilefarmweb.entity.User;
import com.example.mobilefarmweb.service.impl.FarmServiceImpl;
import com.example.mobilefarmweb.service.impl.OrganizationServiceImpl;
import com.example.mobilefarmweb.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/farms")
public class FarmController {
    private final FarmServiceImpl farmService;
    private final UserServiceImpl userService;
    @Autowired
    public FarmController(FarmServiceImpl farmService, UserServiceImpl userService){
        this.farmService=farmService;
        this.userService=userService;
    }
    @GetMapping()
    public String getFarmByOrganizationId(Principal principal, Model model, @RequestParam(name="title", required = false) String title){
        User user= userService.findUserByUsername(principal.getName());
        Organization organization=user.getOrganization();
        List<Farm> farms=farmService.getFarmsByOrganizationIdAndName(organization.getOrganizationId(), title);
        model.addAttribute("farms", farms);
        return "admin/farms";

    }
}
