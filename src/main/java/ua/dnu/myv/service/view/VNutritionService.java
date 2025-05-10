package ua.dnu.myv.service.view;

import ua.dnu.myv.repository.view.VNutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VNutritionService {
    @Autowired
    private VNutritionRepository vNutritionRepository;
    public VNutritionService(VNutritionRepository vNutritionRepository) {
        this.vNutritionRepository = vNutritionRepository;
    }
}
