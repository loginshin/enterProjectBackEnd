package com.enterProject.enterProject.board.controller;

import com.enterProject.enterProject.board.dto.BoardCreateRequest;
import com.enterProject.enterProject.board.dto.BoardDTO;
import com.enterProject.enterProject.board.service.BoardService;
import com.enterProject.enterProject.common.response.EnterApiResponse;
import com.enterProject.enterProject.common.response.dto.EnterApiResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards")
public class BoardRestController {

    private final BoardService boardService;

    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<EnterApiResponseDTO> create(
            @Valid @RequestBody BoardCreateRequest request
            ) {
        BoardDTO result = boardService.create(request);
        return EnterApiResponse.response(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnterApiResponseDTO> find(@PathVariable Long id) {
        BoardDTO result = boardService.findById(id);
        return EnterApiResponse.response(result);
    }
}
