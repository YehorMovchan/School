package ua.dnu.myv.service.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dnu.myv.domain.view.ViewGroupsSchedule;
import ua.dnu.myv.repository.view.VGroupsScheduleRepository;

import java.util.List;

@Service
@Transactional
public class VGroupsScheduleService {
    @Autowired
    private VGroupsScheduleRepository vGroupsScheduleRepository;

    public VGroupsScheduleService(VGroupsScheduleRepository vGroupsScheduleRepository) {
        this.vGroupsScheduleRepository = vGroupsScheduleRepository;
    }

    public List<ViewGroupsSchedule> findByLeader(int leaderId){
        return vGroupsScheduleRepository.findByLeaderId(leaderId);
    }


}
