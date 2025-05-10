package ua.dnu.myv.controller.view;

import ua.dnu.myv.domain.view.ViewSchedule;
import ua.dnu.myv.service.view.VScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("view/schedule")
public class VScheduleController {
    @Autowired
    private VScheduleService vScheduleService;
    public VScheduleController(VScheduleService vScheduleService) {
        this.vScheduleService = vScheduleService;
    }

    @GetMapping("/actual/{day}")
    public List<ViewSchedule> findActual(@PathVariable Integer day){
        return vScheduleService.findActual(day);
    }

    @GetMapping("/history/{from}/{to}/{day}")
    public List<ViewSchedule> findHistory(@PathVariable LocalDate from, @PathVariable LocalDate to, @PathVariable Integer day){
        return vScheduleService.findHistory(from, to, day);
    }

    @GetMapping(value = "/teacher={id}")
    public List<ViewSchedule> findScheduleByStaff(@PathVariable Integer id){
        return vScheduleService.findScheduleByStaff(id);
    }

    @GetMapping(value = "/kid={id}")
    public List<ViewSchedule> findScheduleByKid(@PathVariable Integer id){
        return vScheduleService.findScheduleByKid(id);
    }

}
