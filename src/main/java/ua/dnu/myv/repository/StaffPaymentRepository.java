package ua.dnu.myv.repository;

import ua.dnu.myv.domain.StaffPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StaffPaymentRepository extends JpaRepository<StaffPayment, Long> {

    @Query("select p from StaffPayment p where p.to is null and p.staff=?1")
    public StaffPayment findActual(Integer staff);

    @Query("select p from StaffPayment p where p.staff=?1 and p.to is not null")
    public List<StaffPayment> findHistory(Integer staff);
}
