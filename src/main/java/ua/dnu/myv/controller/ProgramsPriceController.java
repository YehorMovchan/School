package ua.dnu.myv.controller;

import ua.dnu.myv.domain.ProgramsPrice;
import ua.dnu.myv.service.ProgramsPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("programs-price")
public class ProgramsPriceController {
    @Autowired
    private ProgramsPriceService programsPriceService;
    public ProgramsPriceController(ProgramsPriceService programsPriceService) {
        this.programsPriceService = programsPriceService;
    }
    @GetMapping
    public List<ProgramsPrice> findAll() {
        return programsPriceService.findAll();
    }
    @PostMapping
    public void save(@RequestBody ProgramsPrice programsPrice) {
        programsPriceService.save(programsPrice);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ProgramsPrice programsPrice) {
        programsPriceService.update(id, programsPrice);
    }

    @GetMapping("/history/{id}")
    public List<ProgramsPrice> findHistoryById(@PathVariable int id) {
        return programsPriceService.findHistoryById(id);
    }
}
