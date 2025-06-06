package ua.dnu.myv.repository.view;

import ua.dnu.myv.domain.view.ViewSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VScheduleRepository extends JpaRepository<ViewSchedule, Long> {


    @Query("select s from ViewSchedule s where s.dayOfWeek=?2 and (?1 between s.from and s.to or s.from<?1 and s.to is null)")
    List<ViewSchedule> findByDayOfWeek(LocalDate day, Integer dayOfWeek);

    @Query("select s from ViewSchedule s where s.teacherId=?2 and (?1 between s.from and s.to or s.from<?1 and s.to is null)")
    List<ViewSchedule> findByTeacherId(LocalDate day, Integer teacherId);

    @Query("select s from ViewSchedule s where s.classField=?2 and (?1 between s.from and s.to or s.from<?1 and s.to is null)")
    List<ViewSchedule> findByClassField(LocalDate day, Integer classField);

    @Query("select vs from Kid k left join fetch ViewSchedule vs on k.grade=vs.classField where k.id=?1 and vs.to is null order by vs.dayOfWeek, vs.lessonNumber")
    List<ViewSchedule> findSchedulesByKid(int id);

}
