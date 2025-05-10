package ua.dnu.myv.controller;

import org.springframework.web.bind.annotation.*;
import ua.dnu.myv.domain.ProgramsGroup;
import ua.dnu.myv.service.ProgramsGroupService;

import java.util.List;

@RestController
@RequestMapping("/program-groups")
public class ProgramGroupsController {
    private final ProgramsGroupService programsGroupService;
    public ProgramGroupsController(ProgramsGroupService programsGroupService) {
        this.programsGroupService = programsGroupService;
    }

    @PostMapping
    public void save(@RequestBody ProgramsGroup programsGroups) {
        programsGroupService.save(programsGroups);
    }
    @GetMapping
    public List<ProgramsGroup> findAll() {
        return programsGroupService.findAll();
    }

    @GetMapping("program={id}")
    public List<ProgramsGroup> findByProgramId(@PathVariable int id) {
        return programsGroupService.findByProgram(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        programsGroupService.deleteById(id);
    }
}
