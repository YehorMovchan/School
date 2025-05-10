package ua.dnu.myv.controller.view;

import ua.dnu.myv.domain.Program;
import ua.dnu.myv.domain.view.ViewProgram;
import ua.dnu.myv.service.view.VProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("view/program")
public class VProgramController {
    @Autowired
    private VProgramService vProgramService;
    public VProgramController(VProgramService vProgramService) {
        this.vProgramService = vProgramService;
    }

    @GetMapping("/kid={id}")
    public ViewProgram findByKid(@PathVariable int id) {
        return vProgramService.findByKid(id);
    }

    @GetMapping("/history/kid={id}")
    public List<ViewProgram> findHistoryByKid(@PathVariable int id) {
        return vProgramService.findHistoryByKid(id);
    }
    @GetMapping("/program={id}")
    public List<ViewProgram> findByProgram(@PathVariable int id) {
        return vProgramService.findByProgram(id);
    }
}
