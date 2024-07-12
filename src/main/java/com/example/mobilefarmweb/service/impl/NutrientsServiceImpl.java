package com.example.mobilefarmweb.service.impl;

import com.example.mobilefarmweb.entity.Nutrients;
import com.example.mobilefarmweb.repository.NutrientsRepository;
import com.example.mobilefarmweb.service.NutrientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NutrientsServiceImpl implements NutrientsService {
    private NutrientsRepository nutrientsRepository;
    @Autowired
    public NutrientsServiceImpl(NutrientsRepository nutrientsRepository){
        this.nutrientsRepository=nutrientsRepository;
    }

    @Override
    public Nutrients getNutrientsById(Long nutrients_id) {
        return nutrientsRepository.findByNutrientsId(nutrients_id).orElseThrow(()->new NoSuchElementException());
    }

    @Override
    public List<Nutrients> getAllNutrients() {
        return nutrientsRepository.findAll();
    }

    @Override
    public Nutrients saveNutrient(BigDecimal feedUnit, BigDecimal energyExchange, BigDecimal dryMatter, BigDecimal dryProtein, BigDecimal digestedProtein, BigDecimal rawFat, BigDecimal rawFiber, BigDecimal starch, BigDecimal sugar, BigDecimal lysine, BigDecimal methionineAndCystitis, BigDecimal calcium, BigDecimal phosphorus, BigDecimal magnesium, BigDecimal potassium, BigDecimal sulfur, BigDecimal ferrum, BigDecimal copper, BigDecimal zins, BigDecimal manganese, BigDecimal cobalt, BigDecimal iodine, BigDecimal carotene, BigDecimal vitaminE, BigDecimal vitaminD) {
        Nutrients nutrients= new Nutrients();
        nutrients.setFeedUnit(feedUnit);
        nutrients.setEnergyExchange(energyExchange);
        nutrients.setDryMatter(dryMatter);
        nutrients.setDryProtein(dryProtein);
        nutrients.setDigestedProtein(digestedProtein);
        nutrients.setRawFat(rawFat);
        nutrients.setRawFiber(rawFiber);
        nutrients.setStarch(starch);
        nutrients.setSugar(sugar);
        nutrients.setLysine(lysine);
        nutrients.setMethionineAndCystitis(methionineAndCystitis);
        nutrients.setCalcium(calcium);
        nutrients.setPhosphorus(phosphorus);
        nutrients.setMagnesium(magnesium);
        nutrients.setPotassium(potassium);
        nutrients.setSulfur(sulfur);
        nutrients.setFerrum(ferrum);
        nutrients.setCopper(copper);
        nutrients.setZins(zins);
        nutrients.setManganese(manganese);
        nutrients.setCobalt(cobalt);
        nutrients.setIodine(iodine);
        nutrients.setCarotene(carotene);
        nutrients.setVitaminE(vitaminE);
        nutrients.setVitaminD(vitaminD);
        return nutrientsRepository.save(nutrients);
    }
}
