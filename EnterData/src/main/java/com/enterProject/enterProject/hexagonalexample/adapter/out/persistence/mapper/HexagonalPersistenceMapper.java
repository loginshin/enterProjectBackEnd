package com.enterProject.enterProject.hexagonalexample.adapter.out.persistence.mapper;

import com.enterProject.enterProject.hexagonalexample.adapter.out.persistence.entity.HexagonalEntity;
import com.enterProject.enterProject.hexagonalexample.domain.Hexagonal;
import org.springframework.stereotype.Component;

@Component
public class HexagonalPersistenceMapper {

    public HexagonalEntity toEntity(Hexagonal testData) {
        return new HexagonalEntity(testData.id(), testData.value());
    }

    public Hexagonal toDomain(HexagonalEntity entity) {
        return new Hexagonal(entity.getId(), entity.getValue());
    }
}
