package ua.dnu.myv.controller;


import ua.dnu.myv.domain.Parent;
import ua.dnu.myv.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private ParentService parentService;
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }
    @GetMapping
    public List<Parent> findAll() {
        return parentService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Parent> findById(@PathVariable long id) {
        return parentService.findById(id);
    }

    @PostMapping(value = "/save")
    public Parent save(@RequestBody Parent parent) {
        return parentService.save(parent);
    }
}
