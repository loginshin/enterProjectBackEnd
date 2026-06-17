package com.enterProject.enterProject.auth.adapter.in.web.controller;

import com.enterProject.enterProject.auth.adapter.in.web.dto.CurrentUserResponseDTO;
import com.enterProject.enterProject.auth.adapter.in.web.dto.LoginRequestDTO;
import com.enterProject.enterProject.auth.adapter.in.web.dto.SignUpRequestDTO;
import com.enterProject.enterProject.auth.adapter.in.web.dto.TokenResponseDTO;
import com.enterProject.enterProject.auth.application.command.LoginCommand;
import com.enterProject.enterProject.auth.application.command.SignUpCommand;
import com.enterProject.enterProject.auth.application.port.in.LoginUseCase;
import com.enterProject.enterProject.auth.application.port.in.SignUpUseCase;
import com.enterProject.enterProject.auth.application.result.TokenResult;
import com.enterProject.enterProject.common.response.EnterApiResponse;
import com.enterProject.enterProject.common.response.dto.EnterApiResponseDTO;
import com.enterProject.enterProject.common.security.JwtUserPrincipal;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SignUpUseCase signUpUseCase;
    private final LoginUseCase loginUseCase;

    @PostMapping("/signup")
    public ResponseEntity<EnterApiResponseDTO> signUp(@RequestBody @Valid SignUpRequestDTO request) {
        signUpUseCase.signUp(new SignUpCommand(
                request.getEmail(),
                request.getPassword(),
                request.getName()
        ));
        return EnterApiResponse.response(true);
    }

    @PostMapping("/login")
    public ResponseEntity<EnterApiResponseDTO> login(@RequestBody @Valid LoginRequestDTO request) {
        TokenResult result = loginUseCase.login(new LoginCommand(
                request.getEmail(),
                request.getPassword()
        ));
        return EnterApiResponse.response(TokenResponseDTO.from(result));
    }

    @GetMapping("/me")
    public ResponseEntity<EnterApiResponseDTO> me(@AuthenticationPrincipal JwtUserPrincipal principal) {
        return EnterApiResponse.response(CurrentUserResponseDTO.from(principal));
    }
}
