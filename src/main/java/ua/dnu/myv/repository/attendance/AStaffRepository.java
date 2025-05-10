package ua.dnu.myv.repository.attendance;

import ua.dnu.myv.domain.Staff;
import ua.dnu.myv.domain.attendance.StaffAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface AStaffRepository extends JpaRepository<StaffAttendance, Long> {

    @Query("select s from StaffAttendance s where s.staff=?1 and s.date between ?2 and ?3")
    public List<StaffAttendance> findAllByStaffAndDates(Long id, LocalDate from, LocalDate to);

    @Query("select SUM(TIME_TO_SEC(TIMEDIFF(TIMEDIFF(s.end, s.start), TIMEDIFF(s.breaktimeTo, s.breaktimeFrom)))) from StaffAttendance s where s.staff=?1 and s.date between ?2 and ?3")
    public Float findTotalByStaffAndDates(Long staff, LocalDate from, LocalDate to);
}
