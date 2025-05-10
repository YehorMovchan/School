package ua.dnu.myv.repository.view;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.dnu.myv.domain.view.ViewGroupsSchedule;

import java.util.List;

@Repository
public interface VGroupsScheduleRepository extends JpaRepository<ViewGroupsSchedule, Integer> {
    List<ViewGroupsSchedule> findByLeaderId(int leaderId);
}
