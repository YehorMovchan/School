package ua.dnu.myv.repository.view;

import ua.dnu.myv.domain.view.ViewStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface VStaffRepository extends JpaRepository<ViewStaff, Integer> {
    public List<ViewStaff> findAllByOrderByNameAsc();
}
