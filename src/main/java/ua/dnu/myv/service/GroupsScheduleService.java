package ua.dnu.myv.service;

import ua.dnu.myv.domain.GroupsSchedule;
import ua.dnu.myv.repository.GroupsScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class GroupsScheduleService {
    @Autowired
    private GroupsScheduleRepository groupsScheduleRepository;
    public GroupsScheduleService(GroupsScheduleRepository groupsScheduleRepository) {
        this.groupsScheduleRepository = groupsScheduleRepository;
    }

    public List<GroupsSchedule> findAll() {
        return groupsScheduleRepository.findAll();
    }

    public List<GroupsSchedule> findByGroup(int id) {
        return groupsScheduleRepository.findByGroup(id);
    }

    public void update(int id, GroupsSchedule groupsSchedule) {
        groupsScheduleRepository.deleteById(id);
        groupsScheduleRepository.save(groupsSchedule);
    }

    public void delete(int id) {
        groupsScheduleRepository.deleteById(id);
    }
    public void save(GroupsSchedule groupsSchedule) {
        groupsScheduleRepository.save(groupsSchedule);
    }

    public GroupsSchedule findById(int id) {
        return groupsScheduleRepository.findById(id).orElse(null);
    }
}
