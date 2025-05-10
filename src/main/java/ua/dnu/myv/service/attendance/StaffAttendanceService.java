package ua.dnu.myv.service.attendance;

import ua.dnu.myv.domain.Staff;
import ua.dnu.myv.domain.attendance.StaffAttendance;
import ua.dnu.myv.repository.attendance.AStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class StaffAttendanceService {
    @Autowired
    private AStaffRepository aStaffRepository;
    public StaffAttendanceService(AStaffRepository AStaffRepository) {
        this.aStaffRepository = AStaffRepository;
    }

    public void save(StaffAttendance staffAttendance) {
        aStaffRepository.save(staffAttendance);
    }

    public List<StaffAttendance> findAll() {
        return aStaffRepository.findAll();
    }

    public List<StaffAttendance> findAllByStaffAndDates(Long staff, LocalDate from, LocalDate to) {
        return aStaffRepository.findAllByStaffAndDates(staff, from, to);
    }
    public Float findTotalByStaffAndDates(Long staff, LocalDate from, LocalDate to) {
            return aStaffRepository.findTotalByStaffAndDates(staff, from, to)/3600;
    }
}
