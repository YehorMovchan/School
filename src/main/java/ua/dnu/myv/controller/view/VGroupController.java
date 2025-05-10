package ua.dnu.myv.controller.view;

import ua.dnu.myv.domain.view.ViewGroup;
import ua.dnu.myv.service.view.VGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/view/group")
public class VGroupController {
    @Autowired
    private VGroupService vGroupService;
    public VGroupController(VGroupService vGroupService) {
        this.vGroupService = vGroupService;
    }
    @GetMapping
    public List<ViewGroup> findAll() {
        return vGroupService.findAll();
    }

    @GetMapping("/kid={id}")
    public List<ViewGroup> findByKid(@PathVariable int id) {
        return vGroupService.findByKid(id);
    }

    @GetMapping("/group={id}")
    public List<ViewGroup> findByGroup(@PathVariable int id) {
        return vGroupService.findByGroup(id);
    }
}
