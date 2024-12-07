package com.app.App_projects.domain.users;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import org.springframework.beans.BeanUtils;


@Getter
public class RegisterDTO {
    private String login;
    private String password;
    private UsersRole role;


    public RegisterDTO(Users usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

    public RegisterDTO() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UsersRole getRole() {
        return role;
    }
}


