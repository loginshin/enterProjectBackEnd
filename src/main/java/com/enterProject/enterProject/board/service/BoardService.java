package com.enterProject.enterProject.board.service;

import com.enterProject.enterProject.board.domain.BoardEntity;
import com.enterProject.enterProject.board.dto.BoardCreateRequest;
import com.enterProject.enterProject.board.dto.BoardDTO;
import com.enterProject.enterProject.board.dto.BoardUpdateRequest;
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
        BoardEntity savedEntity = boardRepository.save(entity);

        return toDTO(savedEntity);
    }

    // TODO : need refactoring
    @Transactional
    public BoardDTO findById(String boardKey) {

        BoardEntity entity = boardRepository.findById(boardKey)
                .orElseThrow(() -> new RuntimeException("게시글 없음"));

        return toDTO(entity);
    }

    @Transactional
    public BoardDTO update(String boardKey, BoardUpdateRequest request) {
        BoardEntity entity = boardRepository.findById(boardKey)
                .orElseThrow(() -> new RuntimeException("게시글 없음"));

        entity.update(request.title(), request.contents(), request.userKey());

        return toDTO(entity);
    }

    @Transactional
    public void delete(String boardKey) {
        BoardEntity entity = boardRepository.findById(boardKey)
                .orElseThrow(() -> new RuntimeException("게시글 없음"));

        boardRepository.delete(entity);
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
