package com.enterProject.enterProject.cleanexample.infrastructure.persistence;

import com.enterProject.enterProject.cleanexample.application.gateway.CleanGateway;
import com.enterProject.enterProject.cleanexample.domain.Clean;
import com.enterProject.enterProject.cleanexample.infrastructure.persistence.mapper.CleanPersistenceMapper;
import com.enterProject.enterProject.cleanexample.infrastructure.persistence.repository.CleanJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CleanPersistenceAdapter implements CleanGateway {
    private final CleanJpaRepository repository;
    private final CleanPersistenceMapper mapper;

    public Clean save(Clean clean) {
        return mapper.toDomain(repository.save(mapper.toEntity(clean)));
    }

    public Optional<Clean> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    public void delete(Clean clean) {
        repository.deleteById(clean.id());
    }
}
