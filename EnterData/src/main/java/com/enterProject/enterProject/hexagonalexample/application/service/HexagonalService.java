package com.enterProject.enterProject.hexagonalexample.application.service;

import com.enterProject.enterProject.hexagonalexample.application.port.in.HexagonalUseCase;
import com.enterProject.enterProject.hexagonalexample.application.port.out.HexagonalPersistencePort;
import com.enterProject.enterProject.hexagonalexample.domain.Hexagonal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class HexagonalService implements HexagonalUseCase {

    private final HexagonalPersistencePort testPersistencePort;

    @Override
    public Hexagonal create(String value) {
        return testPersistencePort.save(Hexagonal.create(value));
    }

    @Override
    @Transactional(readOnly = true)
    public Hexagonal get(Long id) {
        return load(id);
    }

    @Override
    public Hexagonal update(Long id, String value) {
        return testPersistencePort.save(load(id).update(value));
    }

    @Override
    public void delete(Long id) {
        testPersistencePort.delete(load(id));
    }

    private Hexagonal load(Long id) {
        return testPersistencePort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TEST_ENTITY_NOT_FOUND"));
    }
}
