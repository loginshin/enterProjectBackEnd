package com.enterProject.enterBoot.simplecleanarchitectureexample;

import com.enterProject.enterProject.simplecleanarchitectureexample.domain.Clean;

public record CleanResponse(Long id, String value) {
    public static CleanResponse from(Clean clean) {
        return new CleanResponse(clean.id(), clean.value());
    }
}
