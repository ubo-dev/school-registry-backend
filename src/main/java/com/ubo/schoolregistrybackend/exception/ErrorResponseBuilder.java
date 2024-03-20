package com.ubo.schoolregistrybackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ErrorResponseBuilder {

    public ResponseEntity<Object> buildErrorResponse(Exception exception,
                                                     String message,
                                                     HttpStatus httpStatus,
                                                     WebRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = null;
        if (authentication != null && authentication.isAuthenticated()) {
            userName = authentication.getName();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(formatter);

        ErrorResponse errorResponse = new ErrorResponse(
                userName,
                request.getDescription(true),
                exception.getClass().getName(),
                message,
                httpStatus.value(),
                formattedDateTime
        );


        return ResponseEntity.status(httpStatus).body(errorResponse);
    }
}
