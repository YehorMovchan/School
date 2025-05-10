package ua.dnu.myv.controller.view.attendance;

import ua.dnu.myv.service.view.attendance.VAStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("view/attendance/staff")
public class VAStaffController {
    @Autowired
    private VAStaffService vaStaffService;
    public VAStaffController(VAStaffService vaStaffService) {
        this.vaStaffService = vaStaffService;
    }
}
