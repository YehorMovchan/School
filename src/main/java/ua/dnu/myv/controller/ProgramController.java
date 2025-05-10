package ua.dnu.myv.controller;

import ua.dnu.myv.domain.Program;
import ua.dnu.myv.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/program")
public class ProgramController {
    @Autowired
    private ProgramService programService;
    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @PostMapping
    public void create(@RequestBody Program program) {
        programService.create(program);
    }

    @GetMapping("/kid={id}")
    public Program findByKid(@PathVariable int id) {
        return programService.findByKid(id);
    }

    @PostMapping("/{id}")
    public void edit(@PathVariable int id, @RequestBody Program program){
        programService.edit(id, program);
    }

    @GetMapping("/program={id}")
    public List<Program> findByProgram(@PathVariable int id) {
        return programService.findByProgram(id);
    }

}
