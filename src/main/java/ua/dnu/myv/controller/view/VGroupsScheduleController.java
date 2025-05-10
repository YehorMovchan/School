package ua.dnu.myv.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dnu.myv.domain.view.ViewGroupsSchedule;
import ua.dnu.myv.service.view.VGroupsScheduleService;

import java.util.List;

@RestController
@RequestMapping("view/groups-schedule")
public class VGroupsScheduleController {
    @Autowired
    private VGroupsScheduleService vGroupsScheduleService;

    public VGroupsScheduleController(VGroupsScheduleService vGroupsScheduleService) {
        this.vGroupsScheduleService = vGroupsScheduleService;
    }

    @GetMapping("leader={leaderId}")
    public List<ViewGroupsSchedule> findByLeader(@PathVariable("leaderId") int leaderId) {
        return  vGroupsScheduleService.findByLeader(leaderId);
    }
}
