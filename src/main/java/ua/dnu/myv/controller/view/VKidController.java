package ua.dnu.myv.controller.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dnu.myv.domain.view.ViewKid;
import ua.dnu.myv.service.view.VKidService;

import java.util.List;

@RestController
@RequestMapping("view/kid")
public class VKidController {
    private final VKidService vKidService;

    public VKidController(VKidService vKidService){
        this.vKidService = vKidService;
    }

    @GetMapping("students/grade={grade}")
    public List<ViewKid> findStudentByGrade(@PathVariable("grade") int grade){
        return vKidService.findStudentsByGrade(grade);
    }

    @GetMapping("{id}")
    public ViewKid findById(@PathVariable("id") int id){
        return vKidService.findById(id);
    }
}
