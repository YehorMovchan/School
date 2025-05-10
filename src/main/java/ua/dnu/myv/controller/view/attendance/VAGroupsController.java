package ua.dnu.myv.controller.view.attendance;

import ua.dnu.myv.domain.view.attendance.ViewGroupsAttendance;
import ua.dnu.myv.service.view.attendance.VAGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("view/attendance/group")
public class VAGroupsController {
    @Autowired
    private VAGroupsService vaGroupsService;
    public VAGroupsController(VAGroupsService vaGroupsService) {
        this.vaGroupsService = vaGroupsService;
    }


    @GetMapping("/{kid}/{from}/{to}")
    public List<ViewGroupsAttendance> findAllByKidAndDates(
            @PathVariable("kid") int id,
            @PathVariable("from") LocalDate from,
            @PathVariable("to") LocalDate to){
        return vaGroupsService.findAllByKidAndDates(id, from, to);
    }
}
