package ua.dnu.myv.repository;

import ua.dnu.myv.domain.Kid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface KidRepository extends JpaRepository<Kid, Integer> {

    @Query("select k from Kid k order by k.name")
    List<Kid> findAll();

    List<Kid> findByGrade(int grade);

}
