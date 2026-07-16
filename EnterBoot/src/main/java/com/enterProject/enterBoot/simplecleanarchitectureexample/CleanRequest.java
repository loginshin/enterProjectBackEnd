package com.enterProject.enterBoot.simplecleanarchitectureexample;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CleanRequest(
        @NotBlank(message = "CLEAN_VALUE_REQUIRED")
        @Size(max = 100, message = "CLEAN_VALUE_TOO_LONG")
        String value
) {
}
