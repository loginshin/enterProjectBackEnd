package com.enterProject.enterProject.user.controller;

import com.enterProject.enterProject.common.response.EnterApiResponse;
import com.enterProject.enterProject.common.response.dto.EnterApiResponseDTO;
import com.enterProject.enterProject.user.dto.UserDTO;
import com.enterProject.enterProject.user.dto.UserSignUpDTO;
import com.enterProject.enterProject.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    // 회원 가입
    @PostMapping("/signup")
    public ResponseEntity<EnterApiResponseDTO> signUp(@RequestBody UserSignUpDTO req) {
        UserDTO user = userService.signUp(req);
        return EnterApiResponse.response(user);
    }
}
