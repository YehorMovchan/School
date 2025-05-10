package ua.dnu.myv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dnu.myv.domain.LessonPrice;
import ua.dnu.myv.repository.LessonPriceRepository;

import java.util.List;

@Service
@Transactional
public class LessonPriceService {
    @Autowired
    private LessonPriceRepository lessonPriceRepository;
    public LessonPriceService(LessonPriceRepository lessonPriceRepository) {
        this.lessonPriceRepository = lessonPriceRepository;
    }

    public LessonPrice findLessonPrice(){
        return lessonPriceRepository.findLessonPrice();
    }

    public List<LessonPrice> findAll(){
        return lessonPriceRepository.findAll();
    }


    public void save(LessonPrice lessonPrice){
        LessonPrice oldLp = lessonPriceRepository.findLessonPrice();
        oldLp.setTo(lessonPrice.getFrom());
        oldLp.setReasonOfChange(lessonPrice.getReasonOfChange());
        lessonPrice.setTo(null);
        lessonPrice.setReasonOfChange(null);
        lessonPriceRepository.save(lessonPrice);
    }
}
