package ua.dnu.myv.service.view;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dnu.myv.domain.view.ViewKidProgramGroup;
import ua.dnu.myv.repository.view.VKidProgramGroupsRepository;

import java.util.List;

@Service
@Transactional
public class VKidProgramGroupService {
    private final VKidProgramGroupsRepository vkidProgramGroupsRepository;

    public VKidProgramGroupService(VKidProgramGroupsRepository vkidProgramGroupsRepository) {
        this.vkidProgramGroupsRepository = vkidProgramGroupsRepository;
    }

    public List<ViewKidProgramGroup> findByKidId(int id) {
        return vkidProgramGroupsRepository.findByKidId(id);
    }
}
