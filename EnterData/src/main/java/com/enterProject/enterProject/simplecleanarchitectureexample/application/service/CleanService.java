package com.enterProject.enterProject.simplecleanarchitectureexample.application.service;

import com.enterProject.enterProject.simplecleanarchitectureexample.application.gateway.CleanGateway;
import com.enterProject.enterProject.simplecleanarchitectureexample.application.usecase.CleanUseCase;
import com.enterProject.enterProject.simplecleanarchitectureexample.domain.Clean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CleanService implements CleanUseCase {

    private final CleanGateway cleanGateway;

    public Clean create(String value) {
        return cleanGateway.save(Clean.create(value));
    }

    @Transactional(readOnly = true)
    public Clean get(Long id) {
        return load(id);
    }

    public Clean update(Long id, String value) {
        return cleanGateway.save(load(id).update(value));
    }

    public void delete(Long id) {
        cleanGateway.delete(load(id));
    }

    private Clean load(Long id) {
        return cleanGateway.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CLEAN_ENTITY_NOT_FOUND"));
    }
}
