package com.ubo.schoolregistrybackend.service.auth;

import com.ubo.schoolregistrybackend.dto.auth.LoginRequest;
import com.ubo.schoolregistrybackend.dto.auth.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    /**
     * Authenticates the user with the given email and password.
     *
     * @param request The login request.
     * @return The authentication token.
     */
    LoginResponse authenticate(LoginRequest request);
}
