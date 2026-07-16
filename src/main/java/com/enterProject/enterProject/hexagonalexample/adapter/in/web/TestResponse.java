package com.enterProject.enterProject.hexagonalexample.adapter.in.web;

import com.enterProject.enterProject.hexagonalexample.domain.TestData;

public record TestResponse(Long id, String value) {

    public static TestResponse from(TestData testData) {
        return new TestResponse(testData.id(), testData.value());
    }
}
