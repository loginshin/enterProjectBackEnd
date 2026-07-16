package com.enterProject.enterProject.hexagonal.domain;

public record Hexagonal(Long id, String value) {

    public static Hexagonal create(String value) {
        validate(value);
        return new Hexagonal(null, value.trim());
    }

    public Hexagonal update(String value) {
        validate(value);
        return new Hexagonal(id, value.trim());
    }

    private static void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("TEST_VALUE_REQUIRED");
        }
        if (value.trim().length() > 100) {
            throw new IllegalArgumentException("TEST_VALUE_TOO_LONG");
        }
    }
}
