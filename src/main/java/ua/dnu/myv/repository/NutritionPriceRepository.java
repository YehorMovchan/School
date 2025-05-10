package ua.dnu.myv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.dnu.myv.domain.NutritionPrice;

import java.util.List;
import java.util.Optional;

@Repository
public interface NutritionPriceRepository extends JpaRepository<NutritionPrice, Integer> {
    Optional<NutritionPrice> findByToIsNull();

    @Query("select np from NutritionPrice np order by np.to desc nulls first ")
    List<NutritionPrice> findAll();
}
