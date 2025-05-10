package ua.dnu.myv.repository.view.attendance;

import ua.dnu.myv.domain.view.attendance.ViewAttendanceOnLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VAOnLessonRepository extends JpaRepository<ViewAttendanceOnLesson, Integer> {

    @Query("select vaol from ViewAttendanceOnLesson vaol where vaol.kidId=?1 and vaol.date between ?2 and ?3")
    public List<ViewAttendanceOnLesson> findAllByKidAndDates(int id, LocalDate from, LocalDate to);
}
