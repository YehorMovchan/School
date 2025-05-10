package ua.dnu.myv.user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ua.dnu.myv.service.authentication.AuthenticationService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("{username}")
    public User findByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }

    @PostMapping
    public void register(@RequestBody User user){
        userService.register(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id ){
        userService.delete(id);
    }

}
