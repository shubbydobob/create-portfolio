package com.project.portfolio_create.Portfolio.Controller;

import com.project.portfolio_create.Portfolio.Controller.DTO.UserRequestDTO;
import com.project.portfolio_create.Portfolio.Controller.DTO.UserResponseDTO;
import com.project.portfolio_create.Portfolio.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/me")
    public ResponseEntity<UserResponseDTO> getCurrentUser(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(401).build();
        }
        token = token.substring(7);
        return ResponseEntity.ok(userService.getCurrentUser(token));
    }
}
