package ua.dnu.myv.service.view;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dnu.myv.domain.view.ViewProgramGroup;
import ua.dnu.myv.repository.view.VProgramGroupsRepository;

import java.util.List;

@Service
@Transactional
public class VProgramGroupsService {
    private final VProgramGroupsRepository vProgramGroupsRepository;
    public VProgramGroupsService(VProgramGroupsRepository vProgramGroupsRepository) {
        this.vProgramGroupsRepository = vProgramGroupsRepository;
    }

    public List<ViewProgramGroup> findByProgramId(int id) {
        return vProgramGroupsRepository.findByProgramId(id);
    }
}
