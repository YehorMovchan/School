package ua.dnu.myv.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDTO {
    private String username;
    private String password;
    private String role;
}
