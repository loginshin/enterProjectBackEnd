package com.enterProject.enterProject.board.adapter.in.web.controller;

import com.enterProject.enterProject.board.adapter.in.web.dto.BoardCreateRequest;
import com.enterProject.enterProject.board.adapter.in.web.dto.BoardResponse;
import com.enterProject.enterProject.board.adapter.in.web.dto.BoardUpdateRequest;
import com.enterProject.enterProject.board.application.command.CreateBoardCommand;
import com.enterProject.enterProject.board.application.command.UpdateBoardCommand;
import com.enterProject.enterProject.board.application.port.in.CreateBoardUseCase;
import com.enterProject.enterProject.board.application.port.in.DeleteBoardUseCase;
import com.enterProject.enterProject.board.application.port.in.GetBoardUseCase;
import com.enterProject.enterProject.board.application.port.in.UpdateBoardUseCase;
import com.enterProject.enterProject.common.response.EnterApiResponse;
import com.enterProject.enterProject.common.response.dto.EnterApiResponseDTO;
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
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final CreateBoardUseCase createBoardUseCase;
    private final GetBoardUseCase getBoardUseCase;
    private final UpdateBoardUseCase updateBoardUseCase;
    private final DeleteBoardUseCase deleteBoardUseCase;

    @PostMapping
    public ResponseEntity<EnterApiResponseDTO> create(@Valid @RequestBody BoardCreateRequest request) {
        BoardResponse response = BoardResponse.from(createBoardUseCase.create(
                new CreateBoardCommand(request.title(), request.contents(), request.userKey())
        ));
        return EnterApiResponse.response(response);
    }

    @GetMapping("/{boardKey}")
    public ResponseEntity<EnterApiResponseDTO> get(@PathVariable String boardKey) {
        return EnterApiResponse.response(BoardResponse.from(getBoardUseCase.get(boardKey)));
    }

    @PutMapping("/{boardKey}")
    public ResponseEntity<EnterApiResponseDTO> update(
            @PathVariable String boardKey,
            @Valid @RequestBody BoardUpdateRequest request
    ) {
        BoardResponse response = BoardResponse.from(updateBoardUseCase.update(
                new UpdateBoardCommand(boardKey, request.title(), request.contents(), request.userKey())
        ));
        return EnterApiResponse.response(response);
    }

    @DeleteMapping("/{boardKey}")
    public ResponseEntity<EnterApiResponseDTO> delete(@PathVariable String boardKey) {
        deleteBoardUseCase.delete(boardKey);
        return EnterApiResponse.response(true);
    }
}
