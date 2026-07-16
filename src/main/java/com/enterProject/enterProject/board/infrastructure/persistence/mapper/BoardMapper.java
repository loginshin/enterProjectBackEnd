package com.enterProject.enterProject.board.infrastructure.persistence.mapper;

import com.enterProject.enterProject.board.domain.Board;
import com.enterProject.enterProject.board.infrastructure.persistence.entity.BoardEntity;
import org.springframework.stereotype.Component;

@Component
public class BoardMapper {

    public BoardEntity toEntity(Board board) {
        return BoardEntity.builder()
                .boardKey(board.getBoardKey())
                .boardTitle(board.getTitle())
                .boardContents(board.getContents())
                .createUserKey(board.getCreateUserKey())
                .createDt(board.getCreateAt())
                .updateUserKey(board.getUpdateUserKey())
                .updateDt(board.getUpdateAt())
                .build();
    }

    public Board toDomain(BoardEntity entity) {
        return Board.builder()
                .boardKey(entity.getBoardKey())
                .title(entity.getBoardTitle())
                .contents(entity.getBoardContents())
                .createUserKey(entity.getCreateUserKey())
                .createAt(entity.getCreateDt())
                .updateUserKey(entity.getUpdateUserKey())
                .updateAt(entity.getUpdateDt())
                .build();
    }
}
