package com.project.portfolio_create.Portfolio.Service;

import com.project.portfolio_create.Portfolio.Controller.DTO.UserRequestDTO;
import com.project.portfolio_create.Portfolio.Controller.DTO.UserResponseDTO;
import com.project.portfolio_create.Portfolio.Domain.Users;
import com.project.portfolio_create.Portfolio.Repository.UserRepository;
import com.project.portfolio_create.Portfolio.Security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtUtil jwtUtil;

    // 회원 가입
    public UserResponseDTO register(UserRequestDTO userRequestDTO) {
        if (userRepository.findByUserId(userRequestDTO.getUserId()).isPresent()) {
            throw new RuntimeException("이미 존재하는 사용자입니다.");
        }
        String encodePassword = bCryptPasswordEncoder.encode(userRequestDTO.getPassword());

        Users users = new Users();
        users.setName(userRequestDTO.getName());
        users.setUserId(userRequestDTO.getUserId());
        users.setPassword(encodePassword);
        users.setEmail(userRequestDTO.getEmail());
        users.setCareer(userRequestDTO.getCareer());
        users.setStudyStack(userRequestDTO.getStudyStack());

        userRepository.save(users);

        String token = jwtUtil.generateToken(users.getUserId());

        return new UserResponseDTO(
                users.getId(),
                users.getName(),
                users.getUserId(),
                users.getEmail(),
                users.getCareer(),
                users.getStudyStack(),
                token
        );
    }

    //로그인
    public UserResponseDTO loginUser(UserRequestDTO userRequestDTO) {
        Optional<Users> user = userRepository.findByUserId(userRequestDTO.getUserId());

        if (user.isEmpty() || !bCryptPasswordEncoder.matches(userRequestDTO.getPassword(), user.get().getPassword())) {
            throw new RuntimeException("잘못된 사용자명 또는 비밀번호입니다.");
        }

        String token = jwtUtil.generateToken(user.get().getUserId());

        return new UserResponseDTO(
                user.get().getId(),
                user.get().getName(),
                user.get().getUserId(),
                user.get().getEmail(),
                user.get().getCareer(),
                user.get().getStudyStack(),
                token
                );
    }
}
