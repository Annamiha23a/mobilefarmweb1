package com.example.mobilefarmweb.controller;

import com.example.mobilefarmweb.entity.AnimalPassport;
import com.example.mobilefarmweb.entity.Organization;
import com.example.mobilefarmweb.entity.User;
import com.example.mobilefarmweb.service.AnimalPassportService;
import com.example.mobilefarmweb.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/animal_passports")
public class AnimalPassportController {
    private final AnimalPassportService animalPassportService;
    private final UserServiceImpl userService;

    @Autowired
    public AnimalPassportController(AnimalPassportService animalPassportService, UserServiceImpl userService){
        this.animalPassportService = animalPassportService;
        this.userService=userService;
    }

    @GetMapping("/organization_id")
    public String getAnimalPassportsByOrganizationId(Principal principal, Model model, @RequestParam(name="externalId", required = false) String externalId){
        User user= userService.findUserByUsername(principal.getName());
        Organization organization=user.getOrganization();
        List<AnimalPassport> animalPassports=new ArrayList<>();
        animalPassports= animalPassportService.getAnimalPassportsByOrganizationIdAndExternalId(organization.getOrganizationId(), externalId);
        model.addAttribute("passports", animalPassports);
        return "admin/animalPassports";
    }
    @GetMapping("/organization_id/{externalId}")
    public String getDetailsAnimalPassportsByOrganizationId(@PathVariable("externalId") String externalId,Principal principal, Model model){
        User user= userService.findUserByUsername(principal.getName());
        Organization organization=user.getOrganization();
        AnimalPassport animalPassport= animalPassportService.getAnimalPassportByExternalId(externalId);
        model.addAttribute("passport", animalPassport);
        return "admin/animalPassport-details";
    }
}
