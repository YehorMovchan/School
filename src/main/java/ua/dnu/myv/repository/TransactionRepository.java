package ua.dnu.myv.repository;

import org.springframework.data.jpa.repository.Query;
import ua.dnu.myv.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByKidAndDateAndType(int kid, LocalDate date, int type);

    List<Transaction> findByDateAndIdOfItem(LocalDate date, int id);

    @Query("select sum(t.sum) from Transaction t where t.kid=?1")
    Integer findSumByKid(int kidId);

    @Query("select exists (select t from Transaction t where Year(t.date)=?1 and Month(t.date)=?2 and t.kid=?3 and t.type=4)")
    Boolean checkOnMonthlyPayment(int year, int month, int kid);
}
