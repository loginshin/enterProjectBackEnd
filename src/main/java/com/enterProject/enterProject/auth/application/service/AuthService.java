package com.enterProject.enterProject.auth.application.service;

import com.enterProject.enterProject.auth.application.command.LoginCommand;
import com.enterProject.enterProject.auth.application.command.SignUpCommand;
import com.enterProject.enterProject.auth.application.usecase.LoginUseCase;
import com.enterProject.enterProject.auth.application.usecase.SignUpUseCase;
import com.enterProject.enterProject.auth.application.gateway.IssueTokenPort;
import com.enterProject.enterProject.auth.application.gateway.LoadUserPort;
import com.enterProject.enterProject.auth.application.gateway.PasswordPort;
import com.enterProject.enterProject.auth.application.gateway.SaveUserPort;
import com.enterProject.enterProject.auth.application.result.TokenResult;
import com.enterProject.enterProject.auth.domain.User;
import com.enterProject.enterProject.common.utill.SnowflakeIdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService implements SignUpUseCase, LoginUseCase {

    private final SaveUserPort saveUserPort;
    private final LoadUserPort loadUserPort;
    private final PasswordPort passwordPort;
    private final IssueTokenPort issueTokenPort;
    private final SnowflakeIdGenerator idGenerator;

    @Override
    public void signUp(SignUpCommand command) {
        if (loadUserPort.existsByEmail(command.email())) {
            throw new IllegalArgumentException("EMAIL_ALREADY_EXISTS");
        }

        Long userId = idGenerator.nextId();
        String encodedPassword = passwordPort.encode(command.password());

        User user = User.create(
                userId,
                command.email(),
                encodedPassword,
                command.name()
        );

        saveUserPort.saveUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public TokenResult login(LoginCommand command) {
        User user = loadUserPort.findByEmail(command.email())
                .orElseThrow(() -> new BadCredentialsException("INVALID_EMAIL_OR_PASSWORD"));

        if (!passwordPort.matches(command.password(), user.getPassword())) {
            throw new BadCredentialsException("INVALID_EMAIL_OR_PASSWORD");
        }

        return issueTokenPort.issue(user);
    }
}
