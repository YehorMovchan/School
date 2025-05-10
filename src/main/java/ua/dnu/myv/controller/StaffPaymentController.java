package ua.dnu.myv.controller;

import ua.dnu.myv.domain.StaffPayment;
import ua.dnu.myv.repository.StaffPaymentRepository;
import ua.dnu.myv.service.StaffPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff-payment")
public class StaffPaymentController {

    @Autowired
    private StaffPaymentService staffPaymentService;
    @Autowired
    private StaffPaymentRepository staffPaymentRepository;

    public StaffPaymentController(StaffPaymentService staffPaymentService) {
        this.staffPaymentService = staffPaymentService;
    }

    @PostMapping
    public void save(@RequestBody StaffPayment staffPayment) {
        staffPaymentRepository.save(staffPayment);
    }

    @GetMapping("/{id}")
    public StaffPayment findActual(@PathVariable int id) {
        return staffPaymentService.findActual(id);
    }

    @PostMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody StaffPayment staffPayment) {
        staffPaymentService.update(id, staffPayment);
    }

    @GetMapping("/history/{id}")
    public List<StaffPayment> findHistory(@PathVariable int id) {
        return staffPaymentRepository.findHistory(id);
    }
}
