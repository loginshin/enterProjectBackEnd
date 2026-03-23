package com.enterProject.enterProject.user.service;

import com.enterProject.enterProject.user.domain.UserEntity;
import com.enterProject.enterProject.user.dto.UserDTO;
import com.enterProject.enterProject.user.dto.UserSignUpDTO;
import com.enterProject.enterProject.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원 가입
    public UserDTO signUp(UserSignUpDTO req) {

        // 중복 체크
        if (userRepository.existsByUserId(req.userId())) {
            throw new IllegalArgumentException("DUPLICATE_USER_ID");
        }

        UserEntity user = new UserEntity(
            req.userId(),
            req.userName(),
            req.password()
        );
        userRepository.save(user);

        return new UserDTO(
            user.getUserKey(),
            user.getUserId(),
            user.getUserName(),
            null
        );
    }

    /**
     * 로그인
     * TODO : 로그인 구현
     */
    public void signIn(UserSignUpDTO req) {

    }
}
