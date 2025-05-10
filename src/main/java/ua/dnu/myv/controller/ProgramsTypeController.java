package ua.dnu.myv.controller;

import ua.dnu.myv.domain.ProgramsType;
import ua.dnu.myv.service.ProgramsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("programs-type")
public class ProgramsTypeController {

    @Autowired
    private ProgramsTypeService programsTypeService;
    public ProgramsTypeController(ProgramsTypeService programsTypeService) {
        this.programsTypeService = programsTypeService;
    }

    @PostMapping
    public int save(@RequestBody ProgramsType programsType) {
        return programsTypeService.save(programsType);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        programsTypeService.deleteById(id);
    }

    @GetMapping
    public List<ProgramsType> findAll() {
        return programsTypeService.findAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ProgramsType programsType) {
        programsTypeService.update(id, programsType);
    }

}
