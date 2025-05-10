package ua.dnu.myv.service.attendance;

import ua.dnu.myv.domain.attendance.AttendanceOnLesson;
import ua.dnu.myv.repository.attendance.AOnLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AttendanceOnLessonService {

    @Autowired
    private AOnLessonRepository attendanceRepository;
    public AttendanceOnLessonService(AOnLessonRepository attendance) {
        this.attendanceRepository = attendance;
    }

    public List<AttendanceOnLesson> findAll() {
        return attendanceRepository.findAll();
    }

    public void save(List<AttendanceOnLesson> attendanceOnLesson) {
        attendanceOnLesson.forEach(aol->{
            List<AttendanceOnLesson> matches = attendanceRepository.findByLessonAndKidAndDate(
                    aol.getLesson(),
                    aol.getKid(),
                    aol.getDate()
            );
            if(matches.isEmpty()) {
                attendanceRepository.save(aol);
            }
        });
    }
}
