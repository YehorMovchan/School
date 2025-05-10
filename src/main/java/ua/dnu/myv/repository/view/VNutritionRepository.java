package ua.dnu.myv.repository.view;

import ua.dnu.myv.domain.view.ViewNutrition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VNutritionRepository extends JpaRepository<ViewNutrition, Long> {
}
