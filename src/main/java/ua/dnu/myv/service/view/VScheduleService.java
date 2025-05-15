package ua.dnu.myv.service.view;

import ua.dnu.myv.domain.view.ViewSchedule;
import ua.dnu.myv.repository.view.VScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class VScheduleService {
    @Autowired
    private VScheduleRepository vScheduleRepository;
    public VScheduleService(VScheduleRepository vScheduleRepository) {
        this.vScheduleRepository = vScheduleRepository;
    }

    public List<ViewSchedule> findActual(int day) {
        return vScheduleRepository.findActual(day);
    }

    public List<ViewSchedule> findHistory(LocalDate from, LocalDate to, Integer day) {
        return vScheduleRepository.findHistory(from, to, day);
    }

    public List<ViewSchedule> findScheduleByStaff(int id){
        return vScheduleRepository.findSchedulesByStaff(id);
    }

    public List<ViewSchedule> findScheduleByKid(int id){
        return vScheduleRepository.findSchedulesByKid(id);
    }

    public List<ViewSchedule> findScheduleByGrade(int id){return vScheduleRepository.findViewSchedulesByClassFieldAndToIsNull(id);}
}
