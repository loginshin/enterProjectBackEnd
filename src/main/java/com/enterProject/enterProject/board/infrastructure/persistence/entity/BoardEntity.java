package com.enterProject.enterProject.board.infrastructure.persistence.entity;

import com.github.f4b6a3.uuid.UuidCreator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "boards")
public class BoardEntity implements Serializable {

    @Id
    @Column(name = "board_key", length = 36)
    private String boardKey;

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

    @PrePersist
    public void prePersist() {
        if (boardKey == null) {
            boardKey = UuidCreator.getTimeOrderedEpoch().toString();
        }
    }
}
