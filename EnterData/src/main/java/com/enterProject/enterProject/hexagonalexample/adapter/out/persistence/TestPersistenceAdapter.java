package com.enterProject.enterProject.hexagonalexample.adapter.out.persistence;

import com.enterProject.enterProject.hexagonalexample.application.port.out.TestPersistencePort;
import com.enterProject.enterProject.hexagonalexample.domain.TestData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TestPersistenceAdapter implements TestPersistencePort {

    private final TestJpaRepository testJpaRepository;

    @Override
    public TestData save(TestData testData) {
        TestEntity saved = testJpaRepository.save(new TestEntity(testData.id(), testData.value()));
        return toDomain(saved);
    }

    @Override
    public Optional<TestData> findById(Long id) {
        return testJpaRepository.findById(id).map(TestPersistenceAdapter::toDomain);
    }

    @Override
    public void delete(TestData testData) {
        testJpaRepository.deleteById(testData.id());
    }

    private static TestData toDomain(TestEntity entity) {
        return new TestData(entity.getId(), entity.getValue());
    }
}
