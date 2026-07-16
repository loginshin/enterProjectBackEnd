package com.enterProject.enterProject.hexagonalexample.domain;

public record TestData(Long id, String value) {

    public static TestData create(String value) {
        validate(value);
        return new TestData(null, value.trim());
    }

    public TestData update(String value) {
        validate(value);
        return new TestData(id, value.trim());
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
