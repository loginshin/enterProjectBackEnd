package com.enterProject.enterProject.board.infrastructure.persistence;

import com.enterProject.enterProject.board.infrastructure.persistence.mapper.BoardMapper;
import com.enterProject.enterProject.board.infrastructure.persistence.repository.BoardJpaRepository;
import com.enterProject.enterProject.board.application.gateway.DeleteBoardPort;
import com.enterProject.enterProject.board.application.gateway.LoadBoardPort;
import com.enterProject.enterProject.board.application.gateway.SaveBoardPort;
import com.enterProject.enterProject.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BoardPersistenceAdapter implements SaveBoardPort, LoadBoardPort, DeleteBoardPort {

    private final BoardJpaRepository boardJpaRepository;
    private final BoardMapper boardMapper;

    @Override
    public Board save(Board board) {
        return boardMapper.toDomain(boardJpaRepository.save(boardMapper.toEntity(board)));
    }

    @Override
    public Optional<Board> findById(String boardKey) {
        return boardJpaRepository.findById(boardKey)
                .map(boardMapper::toDomain);
    }

    @Override
    public void delete(Board board) {
        boardJpaRepository.delete(boardMapper.toEntity(board));
    }
}
