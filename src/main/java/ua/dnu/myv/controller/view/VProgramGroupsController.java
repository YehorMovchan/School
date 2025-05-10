package ua.dnu.myv.controller.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dnu.myv.domain.view.ViewProgramGroup;
import ua.dnu.myv.service.view.VProgramGroupsService;

import java.util.List;

@RestController
@RequestMapping("view/program-groups")
public class VProgramGroupsController {
    private final VProgramGroupsService vProgramGroupsService;
    public VProgramGroupsController(VProgramGroupsService vProgramGroupsService) {
        this.vProgramGroupsService = vProgramGroupsService;
    }

    @GetMapping("program={id}")
    public List<ViewProgramGroup> findByProgramId(@PathVariable int id) {
        return vProgramGroupsService.findByProgramId(id);
    }
}
