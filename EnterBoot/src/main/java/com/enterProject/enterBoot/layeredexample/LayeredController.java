package com.enterProject.enterBoot.layeredexample;

import com.enterProject.enterProject.common.response.EnterApiResponse;
import com.enterProject.enterProject.common.response.dto.EnterApiResponseDTO;
import com.enterProject.enterProject.layeredexample.service.LayeredService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/layered/examples")
@RequiredArgsConstructor
public class LayeredController {

    private final LayeredService layeredService;

    @PostMapping
    public ResponseEntity<EnterApiResponseDTO> create(@Valid @RequestBody LayeredRequest request) {
        return EnterApiResponse.response(LayeredResponse.from(layeredService.create(request.value())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnterApiResponseDTO> get(@PathVariable Long id) {
        return EnterApiResponse.response(LayeredResponse.from(layeredService.get(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnterApiResponseDTO> update(@PathVariable Long id, @Valid @RequestBody LayeredRequest request) {
        return EnterApiResponse.response(LayeredResponse.from(layeredService.update(id, request.value())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EnterApiResponseDTO> delete(@PathVariable Long id) {
        layeredService.delete(id);
        return EnterApiResponse.response(true);
    }
}
