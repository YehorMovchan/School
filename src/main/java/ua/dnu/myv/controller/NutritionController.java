package ua.dnu.myv.controller;


import ua.dnu.myv.domain.Nutrition;
import ua.dnu.myv.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nutrition")
public class NutritionController {

    @Autowired
    private NutritionService nutritionService;
    public NutritionController(NutritionService nutritionService) {
        this.nutritionService = nutritionService;
    }

    @PostMapping
    public void create(@RequestBody Nutrition nutrition) {
        nutritionService.create(nutrition);
    }

    @GetMapping("{id}")
    public Nutrition findByKid(@PathVariable int id) {
        return nutritionService.findByKid(id);
    }

    @PostMapping("edit/{id}")
    public void edit(
            @PathVariable int id,
            @RequestBody Nutrition nutrition) {
        nutritionService.edit(id, nutrition);
    }

    @GetMapping("/history/{id}")
    public List<Nutrition> findHistoryByKid(@PathVariable int id){
        return nutritionService.findHistoryByKid(id);
    }
}
