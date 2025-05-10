package ua.dnu.myv.service.view;

import ua.dnu.myv.domain.view.ViewProgramsType;
import ua.dnu.myv.repository.view.VProgramsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VProgramsTypeService {
    @Autowired
    private VProgramsTypeRepository vProgramsTypeRepository;
    public VProgramsTypeService(VProgramsTypeRepository vProgramsTypeRepository) {
        this.vProgramsTypeRepository = vProgramsTypeRepository;
    }

    public List<ViewProgramsType> findAll(){
        return vProgramsTypeRepository.findAll();
    }

    public ViewProgramsType findById(int id) {
        return vProgramsTypeRepository.findById(id);
    }
}

