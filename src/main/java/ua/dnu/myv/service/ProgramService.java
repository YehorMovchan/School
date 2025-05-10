package ua.dnu.myv.service;

import ua.dnu.myv.domain.Nutrition;
import ua.dnu.myv.domain.Program;
import ua.dnu.myv.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ProgramService {

    @Autowired
    private ProgramRepository programRepository;
    public ProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public void create(Program program) {
        programRepository.save(program);
    }

    public List<Program> findAll() {
        return programRepository.findAll();
    }

    public Program findByKid(int kid) {
        return Objects.requireNonNullElseGet(
                programRepository.findByKid(kid),
                Program::new
        );
    }

    public void edit(int id, Program program) {
        Program oldProgram = programRepository.findByKid(id);
        if (oldProgram != null) {
            oldProgram.setTo(program.getTo());
            oldProgram.setReasonOfChange(program.getReasonOfChange());
        }
        program.setFrom(program.getTo());
        program.setTo(null);
        program.setReasonOfChange(null);
        programRepository.save(program);
    }

    public List<Program> findByProgram(Integer program) {
        return programRepository.findByProgram(program);
    }


}
