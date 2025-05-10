package ua.dnu.myv.controller;

import ua.dnu.myv.domain.Schedule;
import ua.dnu.myv.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public List<Schedule> findAll() {
        return scheduleService.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody List<Schedule> schedule) {
        scheduleService.save(schedule);
    }

    @GetMapping("/history-dates")
    public List<Object> findHistoryDates() {
        return scheduleService.findHistoryDates();
    }
}
