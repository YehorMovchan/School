package ua.dnu.myv.controller.view;

import ua.dnu.myv.service.view.VStaffPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("view/staff-payment")
public class VStaffPaymentController {
    @Autowired
    private VStaffPaymentService vStaffPaymentService;
    public VStaffPaymentController(VStaffPaymentService vStaffPaymentService) {
        this.vStaffPaymentService = vStaffPaymentService;
    }
}
