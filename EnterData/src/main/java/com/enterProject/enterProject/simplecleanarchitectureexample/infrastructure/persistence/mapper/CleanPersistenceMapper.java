package com.enterProject.enterProject.simplecleanarchitectureexample.infrastructure.persistence.mapper;

import com.enterProject.enterProject.simplecleanarchitectureexample.domain.Clean;
import com.enterProject.enterProject.simplecleanarchitectureexample.infrastructure.persistence.entity.CleanEntity;
import org.springframework.stereotype.Component;

@Component
public class CleanPersistenceMapper {
    public CleanEntity toEntity(Clean clean) {
        return new CleanEntity(clean.id(), clean.value());
    }

    public Clean toDomain(CleanEntity entity) {
        return new Clean(entity.getId(), entity.getValue());
    }
}
