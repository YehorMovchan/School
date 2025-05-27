package ua.dnu.myv.service;

import ua.dnu.myv.domain.Program;
import ua.dnu.myv.domain.ProgramsType;
import ua.dnu.myv.repository.ProgramsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProgramsTypeService {

    @Autowired
    private ProgramsTypeRepository programsTypeRepository;
    public ProgramsTypeService(ProgramsTypeRepository programsTypeRepository) {
        this.programsTypeRepository = programsTypeRepository;
    }

    public List<ProgramsType> findAll(){ return programsTypeRepository.findAll(); }

    public void update(int id, ProgramsType programsType) {
        ProgramsType pt = programsTypeRepository.findById(id).orElse(null);
        assert pt != null;
        pt.setName(programsType.getName());
        pt.setSchoolIncluded(programsType.isSchoolIncluded());
        pt.setInfo(programsType.getInfo());
    }

    public Integer save(ProgramsType programsType) {
        ProgramsType pt = programsTypeRepository.save(programsType);
        return pt.getId();
    }
    public void deleteById(int id) {
        programsTypeRepository.deleteById(id);
    }
}
