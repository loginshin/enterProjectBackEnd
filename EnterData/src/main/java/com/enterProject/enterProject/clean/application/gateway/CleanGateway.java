package com.enterProject.enterProject.clean.application.gateway;

import com.enterProject.enterProject.clean.domain.Clean;
import java.util.Optional;

public interface CleanGateway {
    Clean save(Clean clean);
    Optional<Clean> findById(Long id);
    void delete(Clean clean);
}
