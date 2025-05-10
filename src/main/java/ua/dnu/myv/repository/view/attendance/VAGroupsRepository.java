package ua.dnu.myv.repository.view.attendance;

import ua.dnu.myv.domain.view.attendance.ViewGroupsAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VAGroupsRepository extends JpaRepository<ViewGroupsAttendance, Integer> {


    @Query("select vga from ViewGroupsAttendance vga where vga.kidId=?1 and vga.date BETWEEN ?2 and ?3")
    public List<ViewGroupsAttendance> findAllByKidAndDates(int id, LocalDate from, LocalDate to);
}
