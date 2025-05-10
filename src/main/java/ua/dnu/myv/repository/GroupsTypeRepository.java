package ua.dnu.myv.repository;

import ua.dnu.myv.domain.GroupsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GroupsTypeRepository extends JpaRepository<GroupsType, Integer> {

}
