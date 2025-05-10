package ua.dnu.myv.service.view.attendance;

import ua.dnu.myv.domain.view.attendance.ViewAttendanceOnLesson;
import ua.dnu.myv.repository.view.attendance.VAOnLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class VAOnLessonService {

    @Autowired
    private VAOnLessonRepository vaOnLessonRepository;
    public VAOnLessonService(VAOnLessonRepository vaOnLessonRepository) {
        this.vaOnLessonRepository = vaOnLessonRepository;
    }

    public List<ViewAttendanceOnLesson> findAllByKidAndDates(int id, LocalDate from, LocalDate to){
        return vaOnLessonRepository.findAllByKidAndDates(id, from, to);
    }
}
