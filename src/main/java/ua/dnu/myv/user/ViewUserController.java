package ua.dnu.myv.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users-list")
public class ViewUserController {
    private final ViewUserService viewUserService;

    public ViewUserController(ViewUserService viewUserService) {
        this.viewUserService = viewUserService;
    }

    @GetMapping
    public List<ViewUser> findAll() {
        return viewUserService.findAll();
    }
}
