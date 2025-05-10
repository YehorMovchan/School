package ua.dnu.myv.service.attendance;

import ua.dnu.myv.domain.attendance.KidAttendance;
import ua.dnu.myv.repository.attendance.AKidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class KidAttendanceService {

    @Autowired
    private AKidRepository attendanceRepository;
    public KidAttendanceService(AKidRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<KidAttendance> findAll(){
        return attendanceRepository.findAll();
    }
}
