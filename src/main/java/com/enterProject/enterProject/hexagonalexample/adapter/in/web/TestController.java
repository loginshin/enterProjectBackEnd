package com.enterProject.enterProject.hexagonalexample.adapter.in.web;

import com.enterProject.enterProject.common.response.EnterApiResponse;
import com.enterProject.enterProject.common.response.dto.EnterApiResponseDTO;
import com.enterProject.enterProject.hexagonalexample.application.port.in.TestUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hexagonal/tests")
@RequiredArgsConstructor
public class TestController {

    private final TestUseCase testUseCase;

    @PostMapping
    public ResponseEntity<EnterApiResponseDTO> create(@Valid @RequestBody TestRequest request) {
        return EnterApiResponse.response(TestResponse.from(testUseCase.create(request.value())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnterApiResponseDTO> get(@PathVariable Long id) {
        return EnterApiResponse.response(TestResponse.from(testUseCase.get(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnterApiResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody TestRequest request
    ) {
        return EnterApiResponse.response(TestResponse.from(testUseCase.update(id, request.value())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EnterApiResponseDTO> delete(@PathVariable Long id) {
        testUseCase.delete(id);
        return EnterApiResponse.response(true);
    }
}
