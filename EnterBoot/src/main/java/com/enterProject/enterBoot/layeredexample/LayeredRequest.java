package com.enterProject.enterBoot.layeredexample;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LayeredRequest(
        @NotBlank(message = "LAYERED_VALUE_REQUIRED")
        @Size(max = 100, message = "LAYERED_VALUE_TOO_LONG")
        String value
) {
}
