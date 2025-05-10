package ua.dnu.myv.controller.view.attendance;

import ua.dnu.myv.service.view.attendance.VAKidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("view/attendance/kid")
public class VAKidController {
    @Autowired
    private VAKidService vakidService;
    public VAKidController(VAKidService vakidService){
        this.vakidService = vakidService;
    }
}
