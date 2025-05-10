package ua.dnu.myv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.dnu.myv.domain.NutritionPrice;
import ua.dnu.myv.service.NutritionPriceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("nutrition-price")
public class NutritionPriceController {
    @Autowired
    private NutritionPriceService nutritionPriceService;
    public NutritionPriceController(NutritionPriceService nutritionPriceService) {
        this.nutritionPriceService = nutritionPriceService;
    }

    @GetMapping
    public Optional<NutritionPrice> findNutritionPrice() {
        return  nutritionPriceService.findNutritionPrice();
    }

    @PostMapping
    public void save(@RequestBody NutritionPrice nutritionPrice) {
        nutritionPriceService.save(nutritionPrice);
    }

    @GetMapping("/all")
    public List<NutritionPrice> findAll() {
        return nutritionPriceService.findAll();
    }
}
