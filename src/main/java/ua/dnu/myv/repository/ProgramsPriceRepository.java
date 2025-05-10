package ua.dnu.myv.repository;

import ua.dnu.myv.domain.ProgramsPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProgramsPriceRepository extends JpaRepository<ProgramsPrice, Integer> {
    @Query("select p from ProgramsPrice p where p.program=?1")
    List<ProgramsPrice> findHistoryById(Integer programsId);

}
