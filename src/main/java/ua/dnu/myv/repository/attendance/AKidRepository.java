package ua.dnu.myv.repository.attendance;

import ua.dnu.myv.domain.attendance.KidAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AKidRepository extends JpaRepository<KidAttendance, Integer> {
}
