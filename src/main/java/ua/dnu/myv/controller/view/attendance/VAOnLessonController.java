package ua.dnu.myv.controller.view.attendance;

import ua.dnu.myv.domain.view.attendance.ViewAttendanceOnLesson;
import ua.dnu.myv.service.view.attendance.VAOnLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("view/attendance/lesson")
public class VAOnLessonController {
    @Autowired
    private VAOnLessonService vaOnLessonService;
    public VAOnLessonController(VAOnLessonService vaOnLessonService) {
        this.vaOnLessonService = vaOnLessonService;
    }

    @GetMapping("{kid}/{from}/{to}")
    public List<ViewAttendanceOnLesson> findAllByKidAndDates(
            @PathVariable("kid") int id,
            @PathVariable("from") LocalDate from,
            @PathVariable("to") LocalDate to
    ){
        return vaOnLessonService.findAllByKidAndDates(id, from, to);
    }
}
