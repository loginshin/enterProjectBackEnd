package com.enterProject.enterProject.cleanexample.infrastructure.persistence.mapper;

import com.enterProject.enterProject.cleanexample.domain.Clean;
import com.enterProject.enterProject.cleanexample.infrastructure.persistence.entity.CleanEntity;
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
