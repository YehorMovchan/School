package ua.dnu.myv.controller.attendance;

import org.springframework.web.bind.annotation.*;
import ua.dnu.myv.domain.attendance.StaffAttendance;
import ua.dnu.myv.service.attendance.StaffAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/attendance/staff")
public class StaffAttendanceController {

    @Autowired
    private StaffAttendanceService staffAttendanceService;

    public StaffAttendanceController(StaffAttendanceService staffAttendanceService) {
        this.staffAttendanceService = staffAttendanceService;
    }

    @PostMapping
    public void save(@RequestBody StaffAttendance staffAttendance) {
        staffAttendanceService.save(staffAttendance);
    }

    @GetMapping(value = "/{id}/{from}/{to}")
    public List<StaffAttendance> findAllByStaffAndDates(
            @PathVariable long id,
            @PathVariable LocalDate from,
            @PathVariable LocalDate to) {
        return staffAttendanceService.findAllByStaffAndDates(id, from, to);
    }

    @GetMapping(value = "/total/{id}/{from}/{to}")
    public Float findTotalByStaffAndDates(
            @PathVariable long id,
            @PathVariable LocalDate from,
            @PathVariable LocalDate to
    ){
        return staffAttendanceService.findTotalByStaffAndDates(id, from, to);
    }

}
