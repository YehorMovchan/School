package ua.dnu.myv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.dnu.myv.domain.LessonPrice;
import ua.dnu.myv.service.LessonPriceService;

import java.util.List;

@RestController
@RequestMapping("lesson-price")
public class LessonPriceController {
    @Autowired
    private LessonPriceService lessonPriceService;
    public LessonPriceController(LessonPriceService lessonPriceService) {
        this.lessonPriceService = lessonPriceService;
    }
    @GetMapping
    public LessonPrice findLessonPrice() {
        return lessonPriceService.findLessonPrice();
    }

    @PostMapping
    public void save(@RequestBody LessonPrice lessonPrice) {
        lessonPriceService.save(lessonPrice);
    }
    @GetMapping("/all")
    public List<LessonPrice> findAll() {
        return lessonPriceService.findAll();
    }
}
