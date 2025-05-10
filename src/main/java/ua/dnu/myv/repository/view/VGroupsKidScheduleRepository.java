package ua.dnu.myv.repository.view;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.dnu.myv.domain.view.ViewGroupsKidSchedule;

import java.util.List;

@Repository
public interface VGroupsKidScheduleRepository extends JpaRepository<ViewGroupsKidSchedule, Integer> {

    @Query("select v from ViewGroupsKidSchedule v where v.kidId=?1 and v.to is null")
    List<ViewGroupsKidSchedule> findByKid(int kid_id);
}
