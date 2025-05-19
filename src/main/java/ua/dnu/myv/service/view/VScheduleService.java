package ua.dnu.myv.service.view;

import ua.dnu.myv.domain.view.ViewSchedule;
import ua.dnu.myv.repository.view.VScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.View;
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

    public List<ViewSchedule> findHistoryByDayOfWeek(LocalDate day, Integer dayOfWeek) {
        return vScheduleRepository.findHistoryByDayOfWeek(day, dayOfWeek);
    }

    public List<ViewSchedule> findHistoryByTeacherId(LocalDate day, Integer teacherId) {
        return vScheduleRepository.findHistoryByTeacherId(day, teacherId);
    }

    public List<ViewSchedule> findHistoryByClassField(LocalDate day, Integer classField) {
        return vScheduleRepository.findHistoryByClassField(day, classField);
    }

    public List<ViewSchedule> findScheduleByStaff(int id){
        return vScheduleRepository.findSchedulesByStaff(id);
    }

    public List<ViewSchedule> findScheduleByKid(int id){
        return vScheduleRepository.findSchedulesByKid(id);
    }

    public List<ViewSchedule> findScheduleByGrade(int id){return vScheduleRepository.findViewSchedulesByClassFieldAndToIsNull(id);}
}
