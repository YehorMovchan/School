package ua.dnu.myv.repository.view;

import ua.dnu.myv.domain.view.ViewStaffPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VStaffPaymentRepository extends JpaRepository<ViewStaffPayment, Integer> {
}
