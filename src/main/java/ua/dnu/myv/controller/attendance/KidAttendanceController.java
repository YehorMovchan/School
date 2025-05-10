package ua.dnu.myv.controller.attendance;

import ua.dnu.myv.service.attendance.KidAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("attendance/kid")
public class KidAttendanceController {

    @Autowired
    private KidAttendanceService kidattendanceService;
    public KidAttendanceController(KidAttendanceService kidattendanceService) {
        this.kidattendanceService = kidattendanceService;
    }
}
