package com.enterProject.enterBoot.clean;

import com.enterProject.enterProject.cleanexample.application.usecase.CleanUseCase;
import com.enterProject.enterProject.common.response.EnterApiResponse;
import com.enterProject.enterProject.common.response.dto.EnterApiResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clean/examples")
@RequiredArgsConstructor
public class CleanController {
    private final CleanUseCase cleanUseCase;

    @PostMapping
    public ResponseEntity<EnterApiResponseDTO> create(@Valid @RequestBody CleanRequest request) {
        return EnterApiResponse.response(CleanResponse.from(cleanUseCase.create(request.value())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnterApiResponseDTO> get(@PathVariable Long id) {
        return EnterApiResponse.response(CleanResponse.from(cleanUseCase.get(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnterApiResponseDTO> update(@PathVariable Long id, @Valid @RequestBody CleanRequest request) {
        return EnterApiResponse.response(CleanResponse.from(cleanUseCase.update(id, request.value())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EnterApiResponseDTO> delete(@PathVariable Long id) {
        cleanUseCase.delete(id);
        return EnterApiResponse.response(true);
    }
}
