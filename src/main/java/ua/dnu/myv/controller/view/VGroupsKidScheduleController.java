package ua.dnu.myv.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dnu.myv.domain.view.ViewGroupsKidSchedule;
import ua.dnu.myv.service.view.VGroupsKidScheduleService;

import java.util.List;

@RestController
@RequestMapping("view/groups-kid-schedule/")
public class VGroupsKidScheduleController {
    @Autowired
    private VGroupsKidScheduleService vgksService;
    public VGroupsKidScheduleController(VGroupsKidScheduleService vgksService) {
        this.vgksService = vgksService;
    }

    @GetMapping("kid={id}")
    public List<ViewGroupsKidSchedule> findByKid(@PathVariable int id) {
        return vgksService.findByKid(id);
    }
}
