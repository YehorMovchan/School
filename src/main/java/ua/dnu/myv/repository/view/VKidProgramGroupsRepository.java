package ua.dnu.myv.repository.view;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.dnu.myv.domain.view.ViewKidProgramGroup;

import java.util.List;

@Repository
public interface VKidProgramGroupsRepository extends JpaRepository<ViewKidProgramGroup, Integer> {

    @Query("select v from ViewKidProgramGroup v where v.kidId=?1 and v.programTo is null")
    List<ViewKidProgramGroup> findByKidId(Integer kidId);

}
