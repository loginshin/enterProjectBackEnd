package com.enterProject.enterProject.hexagonalexample.application.service;

import com.enterProject.enterProject.hexagonalexample.application.port.in.TestUseCase;
import com.enterProject.enterProject.hexagonalexample.application.port.out.TestPersistencePort;
import com.enterProject.enterProject.hexagonalexample.domain.TestData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TestService implements TestUseCase {

    private final TestPersistencePort testPersistencePort;

    @Override
    public TestData create(String value) {
        return testPersistencePort.save(TestData.create(value));
    }

    @Override
    @Transactional(readOnly = true)
    public TestData get(Long id) {
        return load(id);
    }

    @Override
    public TestData update(Long id, String value) {
        return testPersistencePort.save(load(id).update(value));
    }

    @Override
    public void delete(Long id) {
        testPersistencePort.delete(load(id));
    }

    private TestData load(Long id) {
        return testPersistencePort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TEST_ENTITY_NOT_FOUND"));
    }
}
