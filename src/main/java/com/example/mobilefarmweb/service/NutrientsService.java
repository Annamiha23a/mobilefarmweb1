package com.example.mobilefarmweb.service;

import com.example.mobilefarmweb.entity.Feed;
import com.example.mobilefarmweb.entity.Nutrients;

import java.util.List;

public interface NutrientsService {
    Nutrients getNutrientsById(Long nutrients_id);
    List<Nutrients> getAllNutrients();

}
