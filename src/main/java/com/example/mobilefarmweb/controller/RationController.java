package com.example.mobilefarmweb.controller;

import com.example.mobilefarmweb.entity.*;
import com.example.mobilefarmweb.excel.RationsExcelData;
import com.example.mobilefarmweb.service.RationService;
import com.example.mobilefarmweb.service.impl.FeedGroupServiceImpl;
import com.example.mobilefarmweb.service.impl.FeedServiceImpl;
import com.example.mobilefarmweb.service.impl.NutrientsServiceImpl;
import com.example.mobilefarmweb.service.impl.RationServiceImpl;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.poi.ss.usermodel.Workbook;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.mobilefarmweb.excel.Write.writeRation;
import static com.example.mobilefarmweb.excel.Write.writeRation2;

@Controller
@RequestMapping(value = "/rations")
public class RationController {
    private RationServiceImpl rationService;
    private FeedServiceImpl feedService;
    private NutrientsServiceImpl nutrientsService;
    private FeedGroupServiceImpl feedGroupService;
    @Autowired
    public RationController(FeedServiceImpl feedService, NutrientsServiceImpl nutrientsService, RationServiceImpl rationService, FeedGroupServiceImpl feedGroupService){
        this.feedService=feedService;
        this.nutrientsService=nutrientsService;
        this.rationService=rationService;
        this.feedGroupService=feedGroupService;
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
    @GetMapping("/all")
    public String getAllRations(Model model){
        List<Ration> rations=rationService.getAll();
        model.addAttribute("rations", rations);
        return "admin/rations";

    }

    @GetMapping("/update/{id}")
    public String updateRationGet(Model model, @PathVariable("id") Long id){
        model.addAttribute("ration", rationService.getRationById(id));
        model.addAttribute("feeds", feedService.getAll());
        model.addAttribute("feedgroups", feedGroupService.findAll() );
        return "admin/rationUpdate";

    }
    @PostMapping("/save")
    public String saveRations(Model model, @RequestParam(name="title") String  title, @RequestParam(name="kg") List<BigDecimal>  kg, @RequestParam(name="feed") List<Long>  feed, @RequestParam(name="feedGroup") Long  feedGroup){
        System.out.println("Успешно сохранено "+ title + kg + feed + feedGroup);
        FeedGroup feedGroup1=feedGroupService.findByFeedGroupId(feedGroup);
        List<Feed> feeds = new ArrayList<>();
        for(Long f:feed){
            Feed feed1=feedService.findbyId(f);
            feeds.add(feed1);
        }
        rationService.saveRation(title, feedGroup1, feeds, kg );
        model.addAttribute("rations", rationService.getAll());
        return "admin/rations";
    }

    @PostMapping("/excel")
    public ResponseEntity<byte[]> excelAllRations(@RequestBody RationsExcelData requestData){

        FeedGroup feedGroup= feedGroupService.findByFeedGroupId(Long.parseLong(requestData.getFeedgroup()));

        XSSFWorkbook workbook = writeRation(requestData, feedGroup);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            workbook.write(bos);
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        byte[] excelBytes = bos.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=rations.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(excelBytes);
    }

    @PostMapping("/excel2")
    public ResponseEntity<byte[]> excelAllRations2(@RequestBody RationsExcelData requestData){

        FeedGroup feedGroup= feedGroupService.findByFeedGroupId(Long.parseLong(requestData.getFeedgroup()));

        XSSFWorkbook workbook = writeRation2(requestData, feedGroup);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            workbook.write(bos);
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        byte[] excelBytes = bos.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=rations.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(excelBytes);
    }

    @PostMapping("/delete/{id}")
    public String deleteRation(Model model, @PathVariable("id") Long id){
        rationService.deleteRations(rationService.getRationById(id));
        model.addAttribute("rations", rationService.getAll());
        return "admin/rations";
    }
}
