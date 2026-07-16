package com.enterProject.enterBoot.layeredexample;

import com.enterProject.enterProject.layeredexample.domain.LayeredEntity;

public record LayeredResponse(Long id, String value) {
    public static LayeredResponse from(LayeredEntity entity) {
        return new LayeredResponse(entity.getId(), entity.getValue());
    }
}
