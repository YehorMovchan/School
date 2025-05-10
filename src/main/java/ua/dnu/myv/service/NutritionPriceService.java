package ua.dnu.myv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dnu.myv.domain.NutritionPrice;
import ua.dnu.myv.repository.NutritionPriceRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NutritionPriceService {
    @Autowired
    private NutritionPriceRepository nutritionPriceRepository;
    public NutritionPriceService(NutritionPriceRepository nutritionPriceRepository) {
        this.nutritionPriceRepository = nutritionPriceRepository;
    }

    public Optional<NutritionPrice> findNutritionPrice(){
        return nutritionPriceRepository.findByToIsNull();
    }

    public List<NutritionPrice> findAll(){
        return nutritionPriceRepository.findAll();
    }

    public void save(NutritionPrice nutritionPrice){
        NutritionPrice oldNp = nutritionPriceRepository.findByToIsNull().orElse(null);
        assert oldNp != null;
        oldNp.setTo(nutritionPrice.getFrom());
        oldNp.setReasonOfChange(nutritionPrice.getReasonOfChange());
        nutritionPrice.setReasonOfChange(null);
        nutritionPriceRepository.save(nutritionPrice);
    }
}
