package com.shklog.api.service;

import com.shklog.api.domain.Users;
import com.shklog.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    //패스워드 인코더 사용

    public Users signup(Users user) throws Exception {
        Optional<Users> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new Exception("이미 존재하는 이메일입니다.");
        }

        user.setCreatedAt(LocalDateTime.now());  // 현재 시간 기록
        return userRepository.save(user);  // 새로운 유저 저장
    }

}
