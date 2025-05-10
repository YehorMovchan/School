package ua.dnu.myv.controller;

import ua.dnu.myv.domain.GroupsSchedule;
import ua.dnu.myv.service.GroupsScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("groups-schedule")
public class GroupsScheduleController {
    @Autowired
    private GroupsScheduleService groupsScheduleService;
    public GroupsScheduleController(GroupsScheduleService groupsScheduleService) {
        this.groupsScheduleService = groupsScheduleService;
    }

    @GetMapping
    public List<GroupsSchedule> findAll() {
        return groupsScheduleService.findAll();
    }

    @GetMapping("/{id}")
    public List<GroupsSchedule> findByGroup(@PathVariable int id) {
        return groupsScheduleService.findByGroup(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody GroupsSchedule groupsSchedule) {
        groupsScheduleService.update(id, groupsSchedule);
    }

    @PostMapping
    public void save(@RequestBody GroupsSchedule groupsSchedule) {
        groupsScheduleService.save(groupsSchedule);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        groupsScheduleService.delete(id);
    }


}
