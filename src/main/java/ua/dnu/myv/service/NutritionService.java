package ua.dnu.myv.service;

import ua.dnu.myv.domain.Nutrition;
import ua.dnu.myv.repository.NutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class NutritionService {

    @Autowired
    private NutritionRepository nutritionRepository;
    public NutritionService(NutritionRepository nutritionRepository) {
        this.nutritionRepository = nutritionRepository;
    }

    public void create(Nutrition nutrition){
        nutritionRepository.save(nutrition);
    }

    public List<Nutrition> findAll() {
        return nutritionRepository.findAll();
    }

    public Nutrition findByKid(int kid){
        return Objects.requireNonNullElseGet(
                nutritionRepository.findByKid(kid),
                Nutrition::new);
    }

    public void edit(int id, Nutrition nutrition) {
        Nutrition oldNutrition = nutritionRepository.findByKid(id);
        if(oldNutrition != null){
            oldNutrition.setTo(nutrition.getTo());
            oldNutrition.setReasonOfChange(nutrition.getReasonOfChange());
        }
        nutrition.setFrom(nutrition.getTo());
        nutrition.setTo(null);
        nutrition.setReasonOfChange(null);
        nutritionRepository.save(nutrition);
    }

    public List<Nutrition> findHistoryByKid(int kid){
        return nutritionRepository.findHistoryByKid(kid);
    }
}
