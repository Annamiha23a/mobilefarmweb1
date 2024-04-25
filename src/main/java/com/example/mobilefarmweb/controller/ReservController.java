package com.example.mobilefarmweb.controller;

import com.example.mobilefarmweb.excel.Read;
import com.example.mobilefarmweb.excel.Reselv;
import com.example.mobilefarmweb.excel.Write;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
