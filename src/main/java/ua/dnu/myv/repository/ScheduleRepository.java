package ua.dnu.myv.repository;

import ua.dnu.myv.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("select s from Schedule s where s.classField=?1 and s.lessonNumber=?2 and s.dayOfWeek=?3 and s.to is null")
    Schedule findLesson(int cl, int lessonNumber, int dayOfWeek);

    @Query("select s.from, s.to from Schedule s where s.to is not null group by s.from, s.to order by s.from, s.to")
    List<Object> findHistoryDates();

    @Query("select count(s) from Schedule s where s.to is null and s.classField=?1 and s.dayOfWeek=?2")
    int countLesson(Integer classField, Integer dayOfWeek);
}
