package ua.dnu.myv.repository;

import ua.dnu.myv.domain.GroupsSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface GroupsScheduleRepository extends JpaRepository<GroupsSchedule, Integer> {

    @Query("select s from GroupsSchedule s where s._group=?1")
    List<GroupsSchedule> findByGroup(int group);

}
