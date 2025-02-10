package com.project.portfolio_create.Portfolio.Controller;

import com.project.portfolio_create.Portfolio.Controller.DTO.UserRequestDTO;
import com.project.portfolio_create.Portfolio.Controller.DTO.UserResponseDTO;
import com.project.portfolio_create.Portfolio.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity.ok(userService.register(userRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity.ok(userService.loginUser(userRequestDTO));
    }
}
