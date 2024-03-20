package com.ubo.schoolregistrybackend.service.auth;

import com.ubo.schoolregistrybackend.dto.auth.LoginRequest;
import com.ubo.schoolregistrybackend.dto.auth.LoginResponse;
import com.ubo.schoolregistrybackend.exception.EmailNotFoundException;
import com.ubo.schoolregistrybackend.exception.IncorrectPasswordException;
import com.ubo.schoolregistrybackend.repository.UserRepository;
import com.ubo.schoolregistrybackend.service.user.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(UserRepository userRepository, UserService userService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse authenticate(LoginRequest request) {

        var existingUser = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new EmailNotFoundException("No user found with given email: " + request.email()));


        if (!passwordEncoder.matches(request.password(), existingUser.getPassword())) {
            throw new IncorrectPasswordException("Incorrect password for the user with email: " + request.email());
        }

        existingUser.setLastLoginDate(LocalDateTime.now());

        userRepository.save(existingUser);


        return new LoginResponse("Authenticated");
    }
}
