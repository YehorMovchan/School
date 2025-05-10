package ua.dnu.myv.service;

import ua.dnu.myv.domain.GroupsType;
import ua.dnu.myv.repository.GroupsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupsTypeService {

    @Autowired
    private GroupsTypeRepository groupsTypeRepository;
    public GroupsTypeService(GroupsTypeRepository groupsTypeRepository) {
        this.groupsTypeRepository = groupsTypeRepository;
    }

    public List<GroupsType> findAll() {
        return groupsTypeRepository.findAll();
    }

    public void deleteById(int id) {
        groupsTypeRepository.deleteById(id);
    }

    public void save(GroupsType groupsType) {
        groupsTypeRepository.save(groupsType);
    }

    public void update(Integer id, GroupsType groupsType) {
        GroupsType gt = groupsTypeRepository.findById(id).orElse(null);
        assert gt != null;
        gt.setName(groupsType.getName());
        gt.setInfo(groupsType.getInfo());
        gt.setPrice(groupsType.getPrice());
        gt.setLeader(groupsType.getLeader());
    }
}
