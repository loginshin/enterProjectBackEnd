package com.enterProject.enterProject.hexagonal.application.port.in;

import com.enterProject.enterProject.hexagonal.domain.Hexagonal;

public interface HexagonalUseCase {

    Hexagonal create(String value);

    Hexagonal get(Long id);

    Hexagonal update(Long id, String value);

    void delete(Long id);
}
