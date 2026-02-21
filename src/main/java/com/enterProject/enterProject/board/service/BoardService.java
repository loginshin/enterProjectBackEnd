package com.enterProject.enterProject.board.service;

import com.enterProject.enterProject.board.domain.BoardEntity;
import com.enterProject.enterProject.board.dto.BoardDTO;
import com.enterProject.enterProject.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardDTO create(
            String title, String contents, String userKey
    ) {
        String id = UUID.randomUUID().toString();
        BoardEntity entity = new BoardEntity(id, title, contents, userKey);
        boardRepository.save(entity);

        return toDTO(entity);
    }

    // TODO : need refactoring
    public BoardDTO findById(String id) {

        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글 없음"));

        return toDTO(entity);
    }

    private BoardDTO toDTO(BoardEntity entity) {
        return new BoardDTO(
                entity.getBoardId(),
                entity.getBoardTitle(),
                entity.getBoardContents(),
                entity.getCreateUserKey(),
                entity.getCreateDt(),
                entity.getUpdateUserKey(),
                entity.getUpdateDt()
        );
    }

}
