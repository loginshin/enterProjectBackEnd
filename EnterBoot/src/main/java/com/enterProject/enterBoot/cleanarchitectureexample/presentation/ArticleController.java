package com.enterProject.enterBoot.cleanarchitectureexample.presentation;

import com.enterProject.enterProject.cleanarchitectureexample.application.command.*;
import com.enterProject.enterProject.cleanarchitectureexample.application.usecase.*;
import com.enterProject.enterProject.common.response.EnterApiResponse;
import com.enterProject.enterProject.common.response.dto.EnterApiResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clean-architecture/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final CreateArticleUseCase createArticleUseCase;
    private final GetArticleUseCase getArticleUseCase;
    private final UpdateArticleUseCase updateArticleUseCase;
    private final DeleteArticleUseCase deleteArticleUseCase;

    @PostMapping
    public ResponseEntity<EnterApiResponseDTO> create(@Valid @RequestBody ArticleCreateRequest request) {
        return EnterApiResponse.response(ArticleResponse.from(createArticleUseCase.create(
                new CreateArticleCommand(request.title(), request.content()))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnterApiResponseDTO> get(@PathVariable Long id) {
        return EnterApiResponse.response(ArticleResponse.from(getArticleUseCase.get(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnterApiResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ArticleUpdateRequest request) {
        return EnterApiResponse.response(ArticleResponse.from(updateArticleUseCase.update(
                new UpdateArticleCommand(id, request.title(), request.content()))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EnterApiResponseDTO> delete(@PathVariable Long id) {
        deleteArticleUseCase.delete(id);
        return EnterApiResponse.response(true);
    }
}
