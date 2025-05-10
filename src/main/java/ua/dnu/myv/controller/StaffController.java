package ua.dnu.myv.controller;

import ua.dnu.myv.domain.Staff;
import ua.dnu.myv.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    public StaffController(StaffService staffService){
        this.staffService = staffService;
    }
    @GetMapping
    public List<Staff> findAll(){
        return staffService.findAll();
    }
    @PostMapping
    public Integer save(@RequestPart("staff") Staff staff, @RequestPart("passportCopy") MultipartFile passportCopy) throws IOException {
        return staffService.save(staff, passportCopy);
    }

    @GetMapping("/teachers")
    public List<Staff> findTeachers(){
        return staffService.findTeachers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Staff> findById(@PathVariable int id){
        return staffService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public void updateStaff(@PathVariable int id, @RequestPart("staff") Staff staff, @RequestPart("passportCopy") MultipartFile passportCopy) throws IOException {
        staffService.update(id, staff, passportCopy);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteStaff(@PathVariable int id){
        staffService.deleteById(id);
    }
}
