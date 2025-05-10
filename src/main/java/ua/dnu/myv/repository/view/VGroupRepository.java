package ua.dnu.myv.repository.view;

import ua.dnu.myv.domain.view.ViewGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VGroupRepository extends JpaRepository<ViewGroup, Long> {

    @Query("select g from ViewGroup g where g.kidId=?1 and g.to is null order by g.kidName")
    public List<ViewGroup> findByKid(int id);

    @Query("select g from ViewGroup g where g.groupId=?1 and g.to is null order by g.kidName")
    public List<ViewGroup> findByGroup(int id);
}
