package com.enterProject.enterProject.hexagonal.application.port.out;

import com.enterProject.enterProject.hexagonal.domain.Hexagonal;

import java.util.Optional;

public interface HexagonalPersistencePort {

    Hexagonal save(Hexagonal testData);

    Optional<Hexagonal> findById(Long id);

    void delete(Hexagonal testData);
}
