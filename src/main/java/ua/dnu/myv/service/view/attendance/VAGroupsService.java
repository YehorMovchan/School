package ua.dnu.myv.service.view.attendance;

import ua.dnu.myv.domain.view.ViewGroup;
import ua.dnu.myv.domain.view.attendance.ViewGroupsAttendance;
import ua.dnu.myv.repository.view.attendance.VAGroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.View;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class VAGroupsService {

    @Autowired
    private VAGroupsRepository vaGroupsRepository;
    public VAGroupsService(VAGroupsRepository vaGroupsRepository) {
        this.vaGroupsRepository = vaGroupsRepository;
    }

    public List<ViewGroupsAttendance> findAllByKidAndDates(int id, LocalDate from, LocalDate to){
        return vaGroupsRepository.findAllByKidAndDates(id, from, to);
    }
}
