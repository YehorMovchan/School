package ua.dnu.myv.controller.attendance;

import org.springframework.web.bind.annotation.*;
import ua.dnu.myv.domain.attendance.GroupsAttendance;
import ua.dnu.myv.service.attendance.GroupsAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/attendance/group")
public class GroupsAttendanceController {
    @Autowired
    private GroupsAttendanceService groupsAttendanceService;
    public GroupsAttendanceController(GroupsAttendanceService groupsAttendanceService) {
        this.groupsAttendanceService = groupsAttendanceService;
    }

    @PostMapping
    public void saveList(@RequestBody List<GroupsAttendance> groupsAttendance) {
        groupsAttendanceService.saveList(groupsAttendance);
    }
}
