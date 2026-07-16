package com.enterProject.enterProject.cleanexample.application.gateway;

import com.enterProject.enterProject.cleanexample.domain.Clean;
import java.util.Optional;

public interface CleanGateway {
    Clean save(Clean clean);
    Optional<Clean> findById(Long id);
    void delete(Clean clean);
}
