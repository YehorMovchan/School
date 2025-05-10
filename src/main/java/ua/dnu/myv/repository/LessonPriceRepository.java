package ua.dnu.myv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.dnu.myv.domain.LessonPrice;

import java.util.List;

@Repository
public interface LessonPriceRepository extends JpaRepository<LessonPrice, Integer> {
    @Query("select lp from LessonPrice lp where lp.to is null")
    LessonPrice findLessonPrice();

    @Query("select lp from LessonPrice lp order by lp.to nulls first ")
    List<LessonPrice> findAll();
}
