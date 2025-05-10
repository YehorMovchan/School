package ua.dnu.myv.controller.view;

import ua.dnu.myv.domain.view.ViewGroupsType;
import ua.dnu.myv.repository.view.VGroupsTypeRepository;
import ua.dnu.myv.service.view.VGroupsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("view/groups-type")
public class VGroupsTypeController {
    @Autowired
    private VGroupsTypeService vGroupsTypeService;
    public VGroupsTypeController(VGroupsTypeService vGroupsTypeService) {
        this.vGroupsTypeService = vGroupsTypeService;
    }
    @GetMapping
    public List<ViewGroupsType> findAll(){
        return vGroupsTypeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ViewGroupsType> findById(@PathVariable int id){
        return vGroupsTypeService.findById(id);
    }
}
