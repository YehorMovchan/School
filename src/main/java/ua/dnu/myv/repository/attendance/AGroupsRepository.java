package ua.dnu.myv.repository.attendance;

import ua.dnu.myv.domain.attendance.GroupsAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface AGroupsRepository extends JpaRepository<GroupsAttendance, Integer> {
    List<GroupsAttendance> findBy_groupAndDateAndKid(int group, LocalDate date, int kid);
}
