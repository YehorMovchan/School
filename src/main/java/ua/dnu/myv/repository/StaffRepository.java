package ua.dnu.myv.repository;

import ua.dnu.myv.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    @Query("select s from Staff s where s.teacher=true")
    public List<Staff> findTeachers();

    public List<Staff> findAllByOrderByNameAsc();
}
