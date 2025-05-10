package ua.dnu.myv.service.view;

import ua.dnu.myv.repository.view.VStaffPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VStaffPaymentService {
    @Autowired
    private VStaffPaymentRepository vstaffpaymentrepository;
    public VStaffPaymentService(VStaffPaymentRepository vstaffpaymentrepository) {
        this.vstaffpaymentrepository = vstaffpaymentrepository;
    }
}
