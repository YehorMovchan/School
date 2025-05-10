package ua.dnu.myv.service.attendance;

import ua.dnu.myv.domain.attendance.GroupsAttendance;
import ua.dnu.myv.repository.attendance.AGroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupsAttendanceService {

    @Autowired
    private AGroupsRepository aGroupsRepository;
    public GroupsAttendanceService(AGroupsRepository aGroupsRepository) {
        this.aGroupsRepository = aGroupsRepository;
    }

    public List<GroupsAttendance> findAll() {
        return aGroupsRepository.findAll();
    }

    public void saveList(List<GroupsAttendance> list) {
        list.forEach(att->{
            List<GroupsAttendance> matches = aGroupsRepository.findBy_groupAndDateAndKid(
                    att.get_group(),
                    att.getDate(),
                    att.getKid()
            );
            if(matches.isEmpty()){
                aGroupsRepository.save(att);
            }
        });
    }
}
