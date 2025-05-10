package ua.dnu.myv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dnu.myv.domain.ProgramsGroup;
import ua.dnu.myv.repository.ProgramsGroupRepository;

import java.util.List;

@Service
@Transactional
public class ProgramsGroupService {

    private final ProgramsGroupRepository programsGroupRepository;

    public ProgramsGroupService(ProgramsGroupRepository programsGroupRepository) {
        this.programsGroupRepository = programsGroupRepository;
    }

    public void save(ProgramsGroup programsGroup) {
        programsGroupRepository.save(programsGroup);
    }

    public void deleteById(int id) {
        programsGroupRepository.deleteById(id);
    }

    public List<ProgramsGroup> findAll() {
        return programsGroupRepository.findAll();
    }

    public List<ProgramsGroup> findByProgram(int id){
        return programsGroupRepository.findByProgram(id);
    }
}
