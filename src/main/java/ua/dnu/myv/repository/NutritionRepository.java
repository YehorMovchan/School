package ua.dnu.myv.repository;

import ua.dnu.myv.domain.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface NutritionRepository extends JpaRepository<Nutrition, Integer> {

    @Query("select n from Nutrition n where n.kid=?1 and n.to is null")
    public Nutrition findByKid(int kid);

    @Query("select n from Nutrition n where n.kid=?1")
    public List<Nutrition> findHistoryByKid(int kid);
}
