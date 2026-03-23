package com.enterProject.enterProject.board.service;

import com.enterProject.enterProject.board.domain.BoardEntity;
import com.enterProject.enterProject.board.dto.BoardCreateRequest;
import com.enterProject.enterProject.board.dto.BoardDTO;
import com.enterProject.enterProject.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public BoardDTO create(BoardCreateRequest request) {
        BoardEntity entity = new BoardEntity(request.title(), request.contents(), request.userKey());
        boardRepository.save(entity);

        return toDTO(entity);
    }

    // TODO : need refactoring
    @Transactional
    public BoardDTO findById(String boardKey) {

        BoardEntity entity = boardRepository.findById(boardKey)
                .orElseThrow(() -> new RuntimeException("게시글 없음"));

        return toDTO(entity);
    }

    private BoardDTO toDTO(BoardEntity entity) {
        return new BoardDTO(
                entity.getBoardKey(),
                entity.getBoardTitle(),
                entity.getBoardContents(),
                entity.getCreateUserKey(),
                entity.getCreateDt(),
                entity.getUpdateUserKey(),
                entity.getUpdateDt()
        );
    }

}
