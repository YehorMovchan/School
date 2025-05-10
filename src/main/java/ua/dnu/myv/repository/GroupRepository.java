package ua.dnu.myv.repository;

import ua.dnu.myv.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    @Query("select g from Group g where g._group=?1 and g.to is null")
    List<Group> findByGroup(int group);

}
