package com.enterProject.enterProject.hexagonalexample.application.port.out;

import com.enterProject.enterProject.hexagonalexample.domain.Hexagonal;

import java.util.Optional;

public interface HexagonalPersistencePort {

    Hexagonal save(Hexagonal testData);

    Optional<Hexagonal> findById(Long id);

    void delete(Hexagonal testData);
}
