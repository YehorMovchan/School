package ua.dnu.myv.controller.view;

import ua.dnu.myv.service.NutritionService;
import ua.dnu.myv.service.view.VNutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("view/nutrition")
public class VNutritionController {
    @Autowired
    private VNutritionService vNutritionService;
    public VNutritionController(VNutritionService vNutritionService) {
        this.vNutritionService = vNutritionService;
    }
}
