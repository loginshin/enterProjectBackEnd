package com.enterProject.enterProject.cleanexample.application.usecase;

import com.enterProject.enterProject.cleanexample.domain.Clean;

public interface CleanUseCase {
    Clean create(String value);
    Clean get(Long id);
    Clean update(Long id, String value);
    void delete(Long id);
}
