package ua.dnu.myv.controller.authentication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dnu.myv.dto.LoginUserDTO;
import ua.dnu.myv.dto.RegisterUserDTO;
import ua.dnu.myv.jwt.JwtService;
import ua.dnu.myv.responses.LoginResponse;
import ua.dnu.myv.service.authentication.AuthenticationService;
import ua.dnu.myv.user.User;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService,
                                    JwtService jwtService){
        this.authenticationService=authenticationService;
        this.jwtService=jwtService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDTO registerUserDTO){
        User registeredUser = authenticationService.signup(registerUserDTO);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDTO loginUserDTO){
        User authenticateUser = authenticationService.authenticate(loginUserDTO);
        String jwtToken = jwtService.generateToken(authenticateUser);
        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getEXPIRATION_TIME());
        return ResponseEntity.ok(loginResponse);
    }

}
