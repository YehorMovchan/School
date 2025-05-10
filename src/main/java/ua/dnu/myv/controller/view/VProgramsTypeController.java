package ua.dnu.myv.controller.view;

import ua.dnu.myv.domain.view.ViewProgramsType;
import ua.dnu.myv.service.view.VProgramsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("view/programs-type")
public class VProgramsTypeController {
    @Autowired
    private VProgramsTypeService vProgramsTypeService;
    public VProgramsTypeController(VProgramsTypeService vProgramsTypeService) {
        this.vProgramsTypeService = vProgramsTypeService;
    }

    @GetMapping
    public List<ViewProgramsType> findAll(){
        return vProgramsTypeService.findAll();
    }

    @GetMapping("/{id}")
    public ViewProgramsType findById(@PathVariable int id){
        return vProgramsTypeService.findById(id);
    }
}
