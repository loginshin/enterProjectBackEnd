package com.enterProject.enterBoot.clean;

import com.enterProject.enterProject.clean.domain.Clean;

public record CleanResponse(Long id, String value) {
    public static CleanResponse from(Clean clean) {
        return new CleanResponse(clean.id(), clean.value());
    }
}
