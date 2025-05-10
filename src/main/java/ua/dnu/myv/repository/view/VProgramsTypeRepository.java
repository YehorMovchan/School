package ua.dnu.myv.repository.view;

import ua.dnu.myv.domain.view.ViewProgramsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VProgramsTypeRepository extends JpaRepository<ViewProgramsType, Integer> {
    @Query("select v from ViewProgramsType v where v.to is null ")
    List<ViewProgramsType> findAll();

    @Query("select v from ViewProgramsType v where v.to is null and v.programId=?1")
    ViewProgramsType findById(int id);

    @Query("select v from ViewProgramsType v where v.to is not null and v.programId=?1")
    List<ViewProgramsType> findHistoryById(int id);
}
