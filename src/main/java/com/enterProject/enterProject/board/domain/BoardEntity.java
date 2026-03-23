package com.enterProject.enterProject.board.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.github.f4b6a3.uuid.UuidCreator;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "boards")
public class BoardEntity implements Serializable {
    @Id
    @Column(name = "board_key", length = 36)
    private String boardKey;

    @PrePersist
    public void prePersist() {
        if (this.boardKey == null) {
            // UUID v7 (Time-based, sortable, and opaque)
            this.boardKey = UuidCreator.getTimeOrderedEpoch().toString();
        }
    }

    @Column(name = "board_title", length = 150, nullable = false)
    private String boardTitle;

    @Column(name = "board_contents")
    private String boardContents;

    @Column(name = "create_user_key", length = 128)
    private String createUserKey;

    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @Column(name = "update_user_key", length = 128)
    private String updateUserKey;

    @Column(name = "update_dt")
    private LocalDateTime updateDt;

    // 생성(팩토리 느낌)
    public BoardEntity(String title, String contents, String userKey) {
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
