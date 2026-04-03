package com.enterProject.enterProject.auth.domain.exception;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String message) {
        super(message);
    }

    public static InvalidEmailException invalidFormat() {
        return new InvalidEmailException("email.invalid.format");
    }

    public static InvalidEmailException unavailable() {
        return new InvalidEmailException("email.invalid.unavailable");
    }
}
