package com.enterProject.enterProject.board.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "boards")
public class BoardEntity implements Serializable {
    @Id
    @Column(name = "board_id", length = 36)
    private String boardId;

    @Column(name = "board_title", length = 150, nullable = false)
    private String boardTitle;

    @Column(name = "board_contents")
    private String boardContents;

    @Column(name = "create_user_key", length = 36)
    private String createUserKey;

    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @Column(name = "update_user_key", length = 36)
    private String updateUserKey;

    @Column(name = "update_dt")
    private LocalDateTime updateDt;

    // 생성(팩토리 느낌)
    public BoardEntity(String boardId, String title, String contents, String userKey) {
        this.boardId = boardId;
        this.boardTitle = title;
        this.boardContents = contents;
        this.createUserKey = userKey;
        this.updateUserKey = userKey;
        this.createDt = LocalDateTime.now();
        this.updateDt = LocalDateTime.now();
    }

    // 수정은 setter 대신 행위 메서드로
    public void update(String title, String contents, String userKey) {
        this.boardTitle = title;
        this.boardContents = contents;
        this.updateUserKey = userKey;
        this.updateDt = LocalDateTime.now();
    }

    // TODO : Java에서의 JPA 스터디
}
