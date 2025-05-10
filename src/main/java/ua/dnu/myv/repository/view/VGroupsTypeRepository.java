package ua.dnu.myv.repository.view;

import ua.dnu.myv.domain.view.ViewGroupsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface VGroupsTypeRepository extends JpaRepository<ViewGroupsType, Integer> {


}
