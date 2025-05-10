package ua.dnu.myv.service.authentication;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.dnu.myv.dto.LoginUserDTO;
import ua.dnu.myv.dto.RegisterUserDTO;
import ua.dnu.myv.user.User;
import ua.dnu.myv.user.UserRepository;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository,
                                 PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager){
        this.authenticationManager=authenticationManager;
        this.passwordEncoder=passwordEncoder;
        this.userRepository=userRepository;
    }

    public User signup(RegisterUserDTO input){
        User user = new User();
        user.setUsername(input.getUsername());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(input.getRole());
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDTO input){
        User user = userRepository.findByUsername(input.getUsername());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword())
        );
        return user;
    }
}
