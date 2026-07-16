package com.enterProject.enterProject.layeredexample.service;

import com.enterProject.enterProject.layeredexample.domain.LayeredEntity;
import com.enterProject.enterProject.layeredexample.repository.LayeredRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LayeredService {

    private final LayeredRepository layeredRepository;

    public LayeredEntity create(String value) {
        return layeredRepository.save(LayeredEntity.create(value));
    }

    @Transactional(readOnly = true)
    public LayeredEntity get(Long id) {
        return load(id);
    }

    public LayeredEntity update(Long id, String value) {
        LayeredEntity entity = load(id);
        entity.update(value);
        return entity;
    }

    public void delete(Long id) {
        layeredRepository.delete(load(id));
    }

    private LayeredEntity load(Long id) {
        return layeredRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("LAYERED_ENTITY_NOT_FOUND"));
    }
}
