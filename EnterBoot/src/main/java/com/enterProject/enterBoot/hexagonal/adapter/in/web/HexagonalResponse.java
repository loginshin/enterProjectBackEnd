package com.enterProject.enterBoot.hexagonal.adapter.in.web;

import com.enterProject.enterProject.hexagonal.domain.Hexagonal;

public record HexagonalResponse(Long id, String value) {

    public static HexagonalResponse from(Hexagonal hexagonal) {
        return new HexagonalResponse(hexagonal.id(), hexagonal.value());
    }
}
