package com.enterProject.enterProject.cleanexample.domain;

public record Clean(Long id, String value) {
    public static Clean create(String value) {
        validate(value);
        return new Clean(null, value.trim());
    }

    public Clean update(String value) {
        validate(value);
        return new Clean(id, value.trim());
    }

    private static void validate(String value) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException("CLEAN_VALUE_REQUIRED");
        if (value.trim().length() > 100) throw new IllegalArgumentException("CLEAN_VALUE_TOO_LONG");
    }
}
