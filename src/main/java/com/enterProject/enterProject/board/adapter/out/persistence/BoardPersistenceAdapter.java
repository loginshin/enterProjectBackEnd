package com.enterProject.enterProject.board.adapter.out.persistence;

import com.enterProject.enterProject.board.adapter.out.persistence.mapper.BoardMapper;
import com.enterProject.enterProject.board.adapter.out.persistence.repository.BoardJpaRepository;
import com.enterProject.enterProject.board.application.port.out.DeleteBoardPort;
import com.enterProject.enterProject.board.application.port.out.LoadBoardPort;
import com.enterProject.enterProject.board.application.port.out.SaveBoardPort;
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
