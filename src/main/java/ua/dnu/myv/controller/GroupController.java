package ua.dnu.myv.controller;

import ua.dnu.myv.domain.Group;
import ua.dnu.myv.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/{id}")
    public List<Group> findByGroup(@PathVariable int id) {
        return groupService.findByGroup(id);
    }

    @PostMapping
    public void create(@RequestBody Group group) {
        groupService.create(group);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        groupService.delete(id);
    }
}
