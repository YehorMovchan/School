package ua.dnu.myv.service.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dnu.myv.domain.view.ViewGroupsKidSchedule;
import ua.dnu.myv.repository.view.VGroupsKidScheduleRepository;

import java.util.List;

@Service
@Transactional
public class VGroupsKidScheduleService {
    @Autowired
    private VGroupsKidScheduleRepository vgksRepository;
    public VGroupsKidScheduleService(VGroupsKidScheduleRepository vgksRepository) {
        this.vgksRepository = vgksRepository;
    }

    public List<ViewGroupsKidSchedule> findByKid(int kidId){
        return vgksRepository.findByKid(kidId);
    }
}
