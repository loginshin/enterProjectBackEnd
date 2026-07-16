package com.enterProject.enterProject.hexagonalexample.adapter.in.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TestRequest(
        @NotBlank(message = "TEST_VALUE_REQUIRED")
        @Size(max = 100, message = "TEST_VALUE_TOO_LONG")
        String value
) {
}
