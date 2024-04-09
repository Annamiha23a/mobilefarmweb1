package com.example.mobilefarmweb.controller;

import com.example.mobilefarmweb.entity.*;
import com.example.mobilefarmweb.service.AnimalPassportService;
import com.example.mobilefarmweb.service.impl.AnimalPassportServiceImpl;
import com.example.mobilefarmweb.service.impl.FarmServiceImpl;
import com.example.mobilefarmweb.service.impl.FeedGroupServiceImpl;
import com.example.mobilefarmweb.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/animal_passports")
public class AnimalPassportController {
    private final AnimalPassportServiceImpl animalPassportService;
    private final UserServiceImpl userService;

    private final FeedGroupServiceImpl feedGroupService;
    private final FarmServiceImpl farmService;
    @Autowired
    public AnimalPassportController(AnimalPassportServiceImpl animalPassportService, UserServiceImpl userService, FeedGroupServiceImpl feedGroupService, FarmServiceImpl farmService){
        this.animalPassportService = animalPassportService;
        this.userService=userService;
        this.feedGroupService=feedGroupService;
        this.farmService=farmService;
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
    @GetMapping("/organization_id/feedgroup/{externalId}")
    public String getFeedGroupByOrganizationId(@PathVariable("externalId") String externalId,Principal principal, Model model){
        User user= userService.findUserByUsername(principal.getName());
        Organization organization=user.getOrganization();
        AnimalPassport animalPassport= animalPassportService.getAnimalPassportByExternalId(externalId);
        FeedGroup feedGroup=animalPassport.getFeedGroup();
        model.addAttribute("feedGroup", feedGroup);
        return "admin/feedgroup";
    }

    @GetMapping({"/add"})
    public String getAddPassport(Model model, Principal principal){
        User user=userService.getUserByUserName(principal);
        List<Farm> farms=farmService.getFarmsByOrganizationId(user.getOrganization().getOrganizationId());
        model.addAttribute("farms", farms);
        return "admin/animalPassportAdd";
    }
    @PostMapping("/add")
    public String addAnimalPassport(Principal principal, Model model, AnimalPassport animalPassport, @RequestParam String externalId,
//                                    @RequestParam Date createdDate ,
                                    @RequestParam String nickname, @RequestParam String sex, @RequestParam String breed,
                                    @RequestParam Boolean breedingAnimal,
//                                    @RequestParam Date birthDate ,
                                    @RequestParam BigDecimal weight, @RequestParam BigDecimal averageProductivity,
                                    @RequestParam BigDecimal geneticProductivity, @RequestParam BigDecimal weightGrowth, @RequestParam String mother,
                                    @RequestParam String father, @RequestParam Long farm_id){
        User user= userService.getUserByUserName(principal);
        animalPassportService.saveAnimalPassport(animalPassport, externalId,nickname, sex,  breed, breedingAnimal, weight,  averageProductivity, geneticProductivity, weightGrowth,  mother, father,  farm_id);
        List<AnimalPassport> passports=animalPassportService.getAllAnimals();
        model.addAttribute("passports", passports);
        return "admin/animalPassports";
    }
}
