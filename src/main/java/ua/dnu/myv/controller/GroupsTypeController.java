package ua.dnu.myv.controller;

import ua.dnu.myv.domain.GroupsType;
import ua.dnu.myv.service.GroupsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups-type")
public class GroupsTypeController {

    @Autowired
    private GroupsTypeService groupsTypeService;
    public GroupsTypeController(GroupsTypeService groupsTypeService) {
        this.groupsTypeService = groupsTypeService;
    }

    @GetMapping
    public List<GroupsType> findAll() {
        return groupsTypeService.findAll();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        groupsTypeService.deleteById(id);
    }
    @PostMapping
    public void save(@RequestBody GroupsType groupsType) {
        groupsTypeService.save(groupsType);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody GroupsType groupsType) {
        groupsTypeService.update(id, groupsType);
    }
}
