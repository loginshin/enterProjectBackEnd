package com.enterProject.enterProject.auth.adapter.in.web.controller;

import com.enterProject.enterProject.auth.adapter.in.web.dto.SignUpRequestDTO;
import com.enterProject.enterProject.auth.application.command.SignUpCommand;
import com.enterProject.enterProject.auth.application.port.in.SignUpUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SignUpUseCase signUpUseCase;

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid SignUpRequestDTO request) {
        signUpUseCase.signUp(new SignUpCommand(
                request.getEmail(),
                request.getPassword(),
                request.getName()
        ));
    }
}
