package ua.dnu.myv.repository.view;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dnu.myv.domain.view.ViewKid;

import java.util.List;

@Repository
@Transactional
public interface VKidRepository extends JpaRepository<ViewKid, Integer> {
    List<ViewKid> findAllByGradeAndSchoolIncludedIsTrue(int grade);
}
