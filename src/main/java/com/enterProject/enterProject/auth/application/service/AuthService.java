package com.enterProject.enterProject.auth.application.service;

import com.enterProject.enterProject.auth.application.command.SignUpCommand;
import com.enterProject.enterProject.auth.application.port.in.SignUpUseCase;
import com.enterProject.enterProject.auth.application.port.out.SaveUserPort;
import com.enterProject.enterProject.auth.domain.User;
import com.enterProject.enterProject.common.utill.SnowflakeIdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService implements SignUpUseCase {

    private final SaveUserPort saveUserPort;
    private final SnowflakeIdGenerator idGenerator;

    @Override
    public void signUp(SignUpCommand command) {
        // Snowflake로 ID 생성
        Long userId = idGenerator.nextId();
        
        // 도메인 모델 생성
        User user = User.create(
                userId,
                command.email(),
                command.password(),
                command.name()
        );
        
        // 저장 포트 호출
        saveUserPort.saveUser(user);
    }
}
