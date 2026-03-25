package com.enterProject.enterProject.board.controller;

import com.enterProject.enterProject.board.dto.BoardCreateRequest;
import com.enterProject.enterProject.board.dto.BoardDTO;
import com.enterProject.enterProject.board.dto.BoardUpdateRequest;
import com.enterProject.enterProject.board.service.BoardService;
import com.enterProject.enterProject.common.response.EnterApiResponse;
import com.enterProject.enterProject.common.response.dto.EnterApiResponseDTO;
import jakarta.validation.Valid;
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
@RequestMapping("/api/boards")
public class BoardRestController {

    private final BoardService boardService;

    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * 게시글 생성
     * URL: POST /api/boards
     * JSON:
     * {
     *   "title": "게시글 제목",
     *   "contents": "게시글 내용",
     *   "userKey": "사용자 키"
     * }
     */
    @PostMapping
    public ResponseEntity<EnterApiResponseDTO> create(
            @Valid @RequestBody BoardCreateRequest request
            ) {
        BoardDTO result = boardService.create(request);
        return EnterApiResponse.response(result);
    }

    /**
     * 게시글 단건 조회
     * URL: GET /api/boards/{boardKey}
     */
    @GetMapping("/{boardKey}")
    public ResponseEntity<EnterApiResponseDTO> find(@PathVariable String boardKey) {
        BoardDTO result = boardService.findById(boardKey);
        return EnterApiResponse.response(result);
    }

    /**
     * 게시글 수정
     * URL: PUT /api/boards/{boardKey}
     * JSON:
     * {
     *   "title": "수정된 제목",
     *   "contents": "수정된 내용",
     *   "userKey": "수정자 키"
     * }
     */
    @PutMapping("/{boardKey}")
    public ResponseEntity<EnterApiResponseDTO> update(
            @PathVariable String boardKey,
            @Valid @RequestBody BoardUpdateRequest request
    ) {
        BoardDTO result = boardService.update(boardKey, request);
        return EnterApiResponse.response(result);
    }

    /**
     * 게시글 삭제
     * URL: DELETE /api/boards/{boardKey}
     */
    @DeleteMapping("/{boardKey}")
    public ResponseEntity<EnterApiResponseDTO> delete(@PathVariable String boardKey) {
        boardService.delete(boardKey);
        return EnterApiResponse.response(true);
    }
}
