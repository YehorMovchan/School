package ua.dnu.myv.repository.view;

import ua.dnu.myv.domain.view.ViewTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.BindParam;

import java.util.List;

@Repository
public interface VTransactionRepository extends JpaRepository<ViewTransaction, Long> {

    @Query("select t from ViewTransaction t where t.kidId=?1")
    List<ViewTransaction> findByKid(int id);
}
