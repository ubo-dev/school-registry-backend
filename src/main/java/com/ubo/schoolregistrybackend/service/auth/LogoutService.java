package com.ubo.schoolregistrybackend.service.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
public interface LogoutService {

    /**
     * Performs logout for the authenticated user.
     *
     * @param request        The HTTP servlet request.
     * @param response       The HTTP servlet response.
     * @param authentication The authentication object representing the authenticated user.
     */
    void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication);
}
