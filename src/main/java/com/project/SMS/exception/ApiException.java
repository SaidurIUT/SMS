package com.project.SMS.exception;

public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);

    }

    public ApiException() {
        super();

    }

}