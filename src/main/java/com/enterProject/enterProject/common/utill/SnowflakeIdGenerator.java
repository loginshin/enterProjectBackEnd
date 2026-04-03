package com.enterProject.enterProject.common.utill;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * SnowflakeIdGenerator
 * 프로젝트 내부 snowflake 사용 방식 통일
 */
@Component
@RequiredArgsConstructor
public class SnowflakeIdGenerator {

    private final Snowflake snowflake = new Snowflake(1L, 1L);

    public long nextId() {
        return snowflake.nextId();
    }
}