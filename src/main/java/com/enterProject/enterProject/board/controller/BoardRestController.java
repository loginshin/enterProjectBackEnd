package com.enterProject.enterProject.board.controller;

import com.enterProject.enterProject.board.dto.BoardDTO;
import com.enterProject.enterProject.board.service.BoardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards")
public class BoardRestController {

    private final BoardService boardService;

    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public BoardDTO create(
            @RequestParam String title,
            @RequestParam String contents
            ) {
        String userKey = "TEMP_USER";

        return boardService.create(title, contents, userKey);
    }

    @GetMapping("/{id}")
    public BoardDTO find(@PathVariable String id) {
        return boardService.findById(id);
    }
}
