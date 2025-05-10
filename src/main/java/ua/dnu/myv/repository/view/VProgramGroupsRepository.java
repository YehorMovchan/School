package ua.dnu.myv.repository.view;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dnu.myv.domain.view.ViewProgramGroup;

import java.util.List;

@Repository
public interface VProgramGroupsRepository extends JpaRepository<ViewProgramGroup, Integer> {
    List<ViewProgramGroup> findByProgramId(Integer programId);
}
