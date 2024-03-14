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
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
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
    @GetMapping("/add")
    private String addFarm(){
        return "admin/farmAdd";
    }
    @GetMapping("/{id}")
    public String getDetailsFarm(@PathVariable("id") Long id, Model model){
        Farm farm=farmService.getFarmByFarmId(id);
        model.addAttribute(farm);
        return "admin/farm-details";
    }

    @PostMapping("/add")
    public String addFarm(Principal principal, Model model, Farm farm, @RequestParam String gln,
//                          @RequestParam Date registrationDate ,
                          @RequestParam String name, @RequestParam String ownerLastName, @RequestParam String ownerFirstName,
                          @RequestParam String ownerMiddleName, @RequestParam String locationLocationIndex, @RequestParam String locationRegion,
                          @RequestParam String locationDistrict, @RequestParam String locationLocationName, @RequestParam String locationCoordinates,
                          @RequestParam String locationHouseNumber, @RequestParam String locationCorpusNumber, @RequestParam String locationFlatNumber,
                          @RequestParam String locationPhoneNumber, @RequestParam String locationFaxNumber, @RequestParam String locationEmail,
                          @RequestParam String locationStreetName){
        User user= userService.findUserByUsername(principal.getName());
        Organization organization=user.getOrganization();
        farm=farmService.setFarm(farm, gln, name,   ownerLastName,  ownerFirstName,  ownerMiddleName,
                 locationLocationIndex,  locationRegion,   locationDistrict,  locationLocationName,   locationCoordinates,
                 locationHouseNumber,   locationCorpusNumber,  locationFlatNumber,  locationPhoneNumber,  locationFaxNumber,
                 locationEmail, locationStreetName);
        farmService.createFarm(farm, organization);
        List<Farm> farms=farmService.getFarmsByOrganizationId(organization.getOrganizationId());
        model.addAttribute("farms", farms);
        return "admin/farms";
    }
}
