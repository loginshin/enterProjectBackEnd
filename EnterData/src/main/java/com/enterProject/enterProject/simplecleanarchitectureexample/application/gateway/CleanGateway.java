package com.enterProject.enterProject.simplecleanarchitectureexample.application.gateway;

import com.enterProject.enterProject.simplecleanarchitectureexample.domain.Clean;
import java.util.Optional;

public interface CleanGateway {
    Clean save(Clean clean);
    Optional<Clean> findById(Long id);
    void delete(Clean clean);
}
