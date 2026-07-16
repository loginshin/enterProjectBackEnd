package com.enterProject.enterProject.hexagonal.adapter.out.persistence;

import com.enterProject.enterProject.hexagonal.adapter.out.persistence.mapper.HexagonalPersistenceMapper;
import com.enterProject.enterProject.hexagonal.adapter.out.persistence.repository.HexagonalJpaRepository;
import com.enterProject.enterProject.hexagonal.application.port.out.HexagonalPersistencePort;
import com.enterProject.enterProject.hexagonal.domain.Hexagonal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HexagonalPersistenceAdapter implements HexagonalPersistencePort {

    private final HexagonalJpaRepository testJpaRepository;
    private final HexagonalPersistenceMapper testPersistenceMapper;

    @Override
    public Hexagonal save(Hexagonal testData) {
        return testPersistenceMapper.toDomain(
                testJpaRepository.save(testPersistenceMapper.toEntity(testData))
        );
    }

    @Override
    public Optional<Hexagonal> findById(Long id) {
        return testJpaRepository.findById(id).map(testPersistenceMapper::toDomain);
    }

    @Override
    public void delete(Hexagonal testData) {
        testJpaRepository.deleteById(testData.id());
    }
}
