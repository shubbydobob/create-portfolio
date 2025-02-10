package com.project.portfolio_create.Portfolio.Controller.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    private String name;
    private String userId;
    private String password;
    private String email;
    private String career;
    private String studyStack;
}
