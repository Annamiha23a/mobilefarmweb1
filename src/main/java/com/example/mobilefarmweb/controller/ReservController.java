package com.example.mobilefarmweb.controller;

import com.example.mobilefarmweb.entity.Farm;
import com.example.mobilefarmweb.entity.Organization;
import com.example.mobilefarmweb.entity.User;
import com.example.mobilefarmweb.excel.Read;
import com.example.mobilefarmweb.excel.Reselv;
import com.example.mobilefarmweb.excel.Write;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Service
@RequestMapping(value = "/reserv")
public class ReservController {
    @GetMapping()
    public String reading(Model model){
        List<Reselv> reselvs=Read.reading();
        model.addAttribute("reservs", reselvs);
        return "admin/reservs";
    }


    @GetMapping("/one")
    public String readingOne(Model model, @RequestParam String name){
        Reselv reselv=Read.readingOne(name);
        model.addAttribute("reserv", reselv);
        return "admin/reserves";
    }

}
