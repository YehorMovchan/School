package ua.dnu.myv.controller.attendance;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ua.dnu.myv.domain.attendance.AttendanceOnLesson;
import ua.dnu.myv.service.attendance.AttendanceOnLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("attendance/lesson")
public class AttendanceOnLessonController {

    @Autowired
    private AttendanceOnLessonService attendanceOnLessonService;
    public AttendanceOnLessonController(AttendanceOnLessonService attendanceOnLessonService) {
        this.attendanceOnLessonService = attendanceOnLessonService;
    }

    @PostMapping
    public void save(@RequestBody List<AttendanceOnLesson> attendanceOnLesson) {
        attendanceOnLessonService.save(attendanceOnLesson);
    }
}
