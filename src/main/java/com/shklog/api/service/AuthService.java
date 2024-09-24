package com.shklog.api.service;

import com.shklog.api.domain.Users;
import com.shklog.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    //패스워드 인코더 사용

    public Users signup(Users user) {
        user.setPassword(user.getPassword()); // 해싱 로직 추가 필요
        return userRepository.save(user);
    }

}
