package com.enterProject.enterProject.hexagonalexample.application.port.out;

import com.enterProject.enterProject.hexagonalexample.domain.TestData;

import java.util.Optional;

public interface TestPersistencePort {

    TestData save(TestData testData);

    Optional<TestData> findById(Long id);

    void delete(TestData testData);
}
