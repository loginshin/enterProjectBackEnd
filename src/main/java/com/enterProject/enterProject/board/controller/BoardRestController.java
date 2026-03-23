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

    /**
     * 게시글 생성
     * URL: POST /api/boards
     * JSON:
     * {
     *   "title": "게시글 제목",
     *   "contents": "게시글 내용",
     *   "userKey": "사용자 키"
     * }
     * Return:
     * {
     *   "status": "0000",
     *   "message": null,
     *   "data": {
     *     "boardKey": 1,
     *     "boardTitle": "게시글 제목",
     *     "boardContents": "게시글 내용",
     *     "createUserKey": "사용자 키",
     *     "createDt": "2024-03-23T10:00:00",
     *     "updateUserKey": "사용자 키",
     *     "updateDt": "2024-03-23T10:00:00"
     *   }
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
     * URL: GET /api/boards/{id}
     * Return:
     * {
     *   "status": "0000",
     *   "message": null,
     *   "data": {
     *     "boardKey": 1,
     *     "boardTitle": "게시글 제목",
     *     "boardContents": "게시글 내용",
     *     "createUserKey": "사용자 키",
     *     "createDt": "2024-03-23T10:00:00",
     *     "updateUserKey": "사용자 키",
     *     "updateDt": "2024-03-23T10:00:00"
     *   }
     * }
     */
    @GetMapping("/{id}")
    public ResponseEntity<EnterApiResponseDTO> find(@PathVariable Long id) {
        BoardDTO result = boardService.findById(id);
        return EnterApiResponse.response(result);
    }
}
