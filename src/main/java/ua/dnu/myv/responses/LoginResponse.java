package ua.dnu.myv.responses;

import lombok.Getter;
import lombok.Setter;
import ua.dnu.myv.dto.LoginUserDTO;

@Getter
@Setter
public class LoginResponse {
    private String token;
    private long expiresIn;

    public LoginResponse(String token, long expiresIn){
        this.token = token;
        this.expiresIn = expiresIn;
    }

}
