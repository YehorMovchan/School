package ua.dnu.myv.service;

import ua.dnu.myv.domain.Schedule;
import ua.dnu.myv.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> findAll() { return scheduleRepository.findAll(); }

    public void save(List<Schedule> newSchedule) {
        newSchedule.forEach(schedule -> {
            Schedule oldSchedule = scheduleRepository.findLesson(schedule.getClassField(), schedule.getLessonNumber(), schedule.getDayOfWeek());
            if(oldSchedule != null) {
                if(!Objects.equals(oldSchedule.getTeacher(), schedule.getTeacher()) || !Objects.equals(oldSchedule.getSubject(), schedule.getSubject())) {
                    if(schedule.getTeacher()==null && schedule.getSubject()==null) {
                        oldSchedule.setTo(schedule.getFrom());
                    }
                    else{
                        oldSchedule.setTo(schedule.getFrom());
                        scheduleRepository.save(schedule);
                    }
                }
            }
            else{
                scheduleRepository.save(schedule);
            }
        });
    }

    public List<Object> findHistoryDates() {
        return scheduleRepository.findHistoryDates();
    }

    public int countLesson(int grade, int dayOfWeek){
        return scheduleRepository.countLesson(grade, dayOfWeek);
    }

}
