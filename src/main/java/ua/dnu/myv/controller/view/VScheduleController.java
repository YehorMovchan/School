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

    @GetMapping("/day={day}/day-of-week={dayOfWeek}")
    public List<ViewSchedule> findByDayOfWeek(@PathVariable("day") LocalDate day, @PathVariable("dayOfWeek") Integer dayOfWeek){
        return vScheduleService.findByDayOfWeek(day, dayOfWeek);
    }

    @GetMapping("/day={day}/teacher={teacherId}")
    public List<ViewSchedule> findByTeacherId(@PathVariable("day") LocalDate day, @PathVariable("teacherId") Integer teacherId){
        return vScheduleService.findByTeacherId(day, teacherId);
    }

    @GetMapping("/day={day}/grade={classField}")
    public List<ViewSchedule> findByClassField(@PathVariable("day") LocalDate day, @PathVariable("classField") Integer classField){
        return vScheduleService.findByClassField(day, classField);
    }


    @GetMapping(value = "/kid={id}")
    public List<ViewSchedule> findScheduleByKid(@PathVariable Integer id){
        return vScheduleService.findScheduleByKid(id);
    }


}
