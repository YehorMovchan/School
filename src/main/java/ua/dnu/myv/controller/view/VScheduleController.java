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

    @GetMapping("/history/day={day}/day-of-week={dayOfWeek}")
    public List<ViewSchedule> findHistoryByDayOfWeek(@PathVariable("day") LocalDate day, @PathVariable("dayOfWeek") Integer dayOfWeek){
        return vScheduleService.findHistoryByDayOfWeek(day, dayOfWeek);
    }

    @GetMapping("/history/day={day}/teacher={teacherId}")
    public List<ViewSchedule> findHistoryByTeacherId(@PathVariable("day") LocalDate day, @PathVariable("teacherId") Integer teacherId){
        return vScheduleService.findHistoryByTeacherId(day, teacherId);
    }

    @GetMapping("history/day={day}/class={classField}")
    public List<ViewSchedule> findHistoryByClassField(@PathVariable("day") LocalDate day, @PathVariable("classField") Integer classField){
        return vScheduleService.findHistoryByClassField(day, classField);
    }



    @GetMapping(value = "/teacher={id}")
    public List<ViewSchedule> findScheduleByStaff(@PathVariable Integer id){
        return vScheduleService.findScheduleByStaff(id);
    }

    @GetMapping(value = "/kid={id}")
    public List<ViewSchedule> findScheduleByKid(@PathVariable Integer id){
        return vScheduleService.findScheduleByKid(id);
    }

    @GetMapping(value = "/grade={id}")
    public List<ViewSchedule> findScheduleByGrade(@PathVariable Integer id){
        return vScheduleService.findScheduleByGrade(id);
    }

}
