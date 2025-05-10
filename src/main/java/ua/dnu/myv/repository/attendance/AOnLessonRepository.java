package ua.dnu.myv.repository.attendance;

import ua.dnu.myv.domain.attendance.AttendanceOnLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface AOnLessonRepository extends JpaRepository<AttendanceOnLesson, Long> {

    List<AttendanceOnLesson> findByLessonAndKidAndDate(int lesson, int kid, LocalDate date);
}
