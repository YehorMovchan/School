package ua.dnu.myv.repository.view;

import ua.dnu.myv.domain.view.ViewSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VScheduleRepository extends JpaRepository<ViewSchedule, Long> {

    @Query("select sch from ViewSchedule sch where sch.to is null and sch.dayOfWeek=?1")
    List<ViewSchedule> findActual(int day);

    @Query("select s1 from ViewSchedule s1 where(s1.from<=?1 and (s1.to>=?2 or s1.to is null) and s1.dayOfWeek=?3) and(s1.to is null or not exists (select 1 from ViewSchedule s2 where s2.classField=s1.classField and s2.dayOfWeek=s1.dayOfWeek and s2.lessonNumber=s1.lessonNumber and s2.to is not null and s2.from>s1.from)) ")
    List<ViewSchedule> findHistory(LocalDate from, LocalDate to, Integer dayOfWeek);

    @Query("select vs from Kid k left join fetch ViewSchedule vs on k.grade=vs.classField where k.id=?1 and vs.to is null order by vs.dayOfWeek, vs.lessonNumber")
    List<ViewSchedule> findSchedulesByKid(int id);

    @Query("select vs from ViewSchedule vs where vs.teacherId=?1 and  vs.to is null order by vs.dayOfWeek, vs.lessonNumber")
    List<ViewSchedule> findSchedulesByStaff(int id);

    List<ViewSchedule> findViewSchedulesByClassField(int id);
}
