package ua.dnu.myv.controller;

import ua.dnu.myv.domain.Kid;
import ua.dnu.myv.service.KidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/kid")
public class KidController {

    @Autowired
    private KidService kidService;
    public KidController(KidService kidService){
        this.kidService=kidService;
    }

    @GetMapping
    public List<Kid> findAll(){
        return  kidService.findAll();
    }

    @GetMapping(value = "/grade={grade}")
    public List<Kid> findByGrade(@PathVariable int grade){
        return kidService.findByGrade(grade);
    }

    @GetMapping(value = "/students/grade={grade}")
    public List<Kid> findStudentByGrade(@PathVariable int grade){
        return kidService.findStudentByGrade(grade);
    }

    @GetMapping(value = "/{id}")
    public Optional<Kid> findById(@PathVariable int id){
        return kidService.findById(id);
    }

    @PostMapping()
    public Integer save(@RequestPart("kid") Kid kid, @RequestPart("birthCertificate") MultipartFile birthCertificate) throws IOException {
        return kidService.save(kid, birthCertificate);
    }

    @PutMapping (value = "/{id}")
    public void update(@PathVariable int id, @RequestPart("kid") Kid kid, @RequestPart("birthCertificate") MultipartFile birthCertificate) throws IOException {
        kidService.update(id, kid, birthCertificate);
    }


    @PostMapping(value = "/update/parent/{id}")
    public void updateParents(@PathVariable int id, @RequestBody Kid kid){
        kidService.updateParents(id, kid);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        kidService.deleteById(id);
    }

}
