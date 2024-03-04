package com.example.mobilefarmweb.controller;

import com.example.mobilefarmweb.entity.Organization;
import com.example.mobilefarmweb.entity.User;
import com.example.mobilefarmweb.service.impl.OrganizationServiceImpl;
import com.example.mobilefarmweb.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping(value = "/organizations")
public class OrganizationController {

    private final OrganizationServiceImpl organizationService;
    private final UserServiceImpl userService;

    @Autowired
    public OrganizationController(OrganizationServiceImpl organizationService, UserServiceImpl userService){
        this.organizationService = organizationService;
        this.userService=userService;
    }
    @GetMapping("/unp")
    @ResponseStatus(HttpStatus.OK)
    public String getOrganizationByUNP(Principal principal, Model model){
        User user= userService.findUserByUsername(principal.getName());
        Organization organization=user.getOrganization();
        model.addAttribute(organization);
        //Organization org = organizationService.getOrganizationByUNP(unp);
        return "admin/getUnp";
    }
}
