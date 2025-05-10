package ua.dnu.myv.repository;

import ua.dnu.myv.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProgramRepository extends JpaRepository<Program, Integer> {

    @Query("select p from Program p where p.kid=?1 and p.to is null")
    public Program findByKid(int kid);

    @Query("select p from Program p where p.program=?1 and p.to is null")
    public List<Program> findByProgram(int program);
}
