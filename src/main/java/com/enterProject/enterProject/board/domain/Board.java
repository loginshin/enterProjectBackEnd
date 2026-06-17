package com.enterProject.enterProject.board.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Board {

    private final String boardKey;
    private final String title;
    private final String contents;
    private final String createUserKey;
    private final LocalDateTime createAt;
    private final String updateUserKey;
    private final LocalDateTime updateAt;

    public static Board create(String title, String contents, String userKey) {
        validate(title, contents, userKey);
        LocalDateTime now = LocalDateTime.now();
        return Board.builder()
                .title(title)
                .contents(contents)
                .createUserKey(userKey)
                .createAt(now)
                .updateUserKey(userKey)
                .updateAt(now)
                .build();
    }

    public Board update(String title, String contents, String userKey) {
        validate(title, contents, userKey);
        return Board.builder()
                .boardKey(boardKey)
                .title(title)
                .contents(contents)
                .createUserKey(createUserKey)
                .createAt(createAt)
                .updateUserKey(userKey)
                .updateAt(LocalDateTime.now())
                .build();
    }

    private static void validate(String title, String contents, String userKey) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("BOARD_TITLE_REQUIRED");
        }
        if (title.length() > 150) {
            throw new IllegalArgumentException("BOARD_TITLE_TOO_LONG");
        }
        if (contents == null || contents.isBlank()) {
            throw new IllegalArgumentException("BOARD_CONTENTS_REQUIRED");
        }
        if (userKey == null || userKey.isBlank()) {
            throw new IllegalArgumentException("BOARD_USER_REQUIRED");
        }
    }
}
