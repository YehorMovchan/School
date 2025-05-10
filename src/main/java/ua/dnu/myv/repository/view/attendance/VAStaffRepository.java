package ua.dnu.myv.repository.view.attendance;

import ua.dnu.myv.domain.view.attendance.ViewStaffAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VAStaffRepository extends JpaRepository<ViewStaffAttendance, Integer> {
}
