package com.example.mobilefarmweb.service;

import com.example.mobilefarmweb.entity.Feed;
import com.example.mobilefarmweb.entity.Nutrients;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

public interface NutrientsService {
    Nutrients getNutrientsById(Long nutrients_id);
    List<Nutrients> getAllNutrients();

    Nutrients saveNutrient(BigDecimal feedUnit,  BigDecimal energyExchange,  BigDecimal dryMatter,  BigDecimal dryProtein,  BigDecimal digestedProtein,  BigDecimal rawFat,  BigDecimal rawFiber,  BigDecimal starch,  BigDecimal sugar,  BigDecimal lysine,  BigDecimal methionineAndCystitis,  BigDecimal calcium,  BigDecimal phosphorus,  BigDecimal magnesium, BigDecimal potassium,  BigDecimal sulfur,  BigDecimal ferrum,  BigDecimal copper, BigDecimal zins,  BigDecimal manganese,  BigDecimal cobalt,  BigDecimal iodine,   BigDecimal carotene, BigDecimal vitaminE, BigDecimal vitaminD);

}
