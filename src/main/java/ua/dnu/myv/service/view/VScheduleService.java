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


    public List<ViewSchedule> findByDayOfWeek(LocalDate day, Integer dayOfWeek) {
        return vScheduleRepository.findByDayOfWeek(day, dayOfWeek);
    }

    public List<ViewSchedule> findByTeacherId(LocalDate day, Integer teacherId) {
        return vScheduleRepository.findByTeacherId(day, teacherId);
    }

    public List<ViewSchedule> findByClassField(LocalDate day, Integer classField) {
        return vScheduleRepository.findByClassField(day, classField);
    }

    public List<ViewSchedule> findScheduleByKid(int id){
        return vScheduleRepository.findSchedulesByKid(id);
    }

}
