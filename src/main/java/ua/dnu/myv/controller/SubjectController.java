package ua.dnu.myv.controller;

import org.springframework.web.bind.annotation.*;
import ua.dnu.myv.domain.Subject;
import ua.dnu.myv.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> findAll() {
        return subjectService.findAll();
    }

    @PostMapping
    public void save(@RequestBody Subject subject) {
        subjectService.save(subject);
    }

    @PutMapping
    public void update(@RequestBody Subject subject) {
        subjectService.update(subject);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        subjectService.delete(id);
    }
}
