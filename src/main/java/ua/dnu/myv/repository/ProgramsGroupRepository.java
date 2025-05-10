package ua.dnu.myv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dnu.myv.domain.Program;
import ua.dnu.myv.domain.ProgramsGroup;

import java.util.List;

@Repository
public interface ProgramsGroupRepository extends JpaRepository<ProgramsGroup, Integer> {

    List<ProgramsGroup> findByProgram(Integer program);
}
