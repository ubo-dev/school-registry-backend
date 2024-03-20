package com.ubo.schoolregistrybackend.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private final int status;
    private final String message;
    private String description;
    private String classTrace;
    private String stackTrace;
    private String userName;
    private String thrownAt;
    private List<ValidationError> errors;

    public ErrorResponse(String userName, String description, String name, String message, int value, String formattedDateTime) {
        this.userName = userName;
        this.description = description;
        this.classTrace = name;
        this.message = message;
        this.status = value;
        this.thrownAt = formattedDateTime;
    }


    private record ValidationError(String field, String message) {
    }

    public void addValidationError(String field, String message) {
        if (Objects.isNull(errors)) {
            errors = new ArrayList<>();
        }
        errors.add(new ValidationError(field, message));
    }

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }


}