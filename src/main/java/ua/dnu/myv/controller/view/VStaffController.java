package ua.dnu.myv.controller.view;

import ua.dnu.myv.domain.view.ViewStaff;
import ua.dnu.myv.service.view.VStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("view/staff")
public class VStaffController {
    @Autowired
    private VStaffService vstaffService;
    public VStaffController(VStaffService vstaffService) {
        this.vstaffService = vstaffService;
    }

    @GetMapping
    public List<ViewStaff> findALlByOrderByNameAsc(){
        return  vstaffService.findAllByOrderByNameAsc();
    }
}
