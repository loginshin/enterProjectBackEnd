package com.enterProject.enterBoot.hexagonalexample.adapter.in.web;

import com.enterProject.enterProject.hexagonalexample.domain.Hexagonal;

public record HexagonalResponse(Long id, String value) {

    public static HexagonalResponse from(Hexagonal hexagonal) {
        return new HexagonalResponse(hexagonal.id(), hexagonal.value());
    }
}
