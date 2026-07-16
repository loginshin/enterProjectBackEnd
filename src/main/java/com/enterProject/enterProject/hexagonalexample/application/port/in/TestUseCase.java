package com.enterProject.enterProject.hexagonalexample.application.port.in;

import com.enterProject.enterProject.hexagonalexample.domain.TestData;

public interface TestUseCase {

    TestData create(String value);

    TestData get(Long id);

    TestData update(Long id, String value);

    void delete(Long id);
}
