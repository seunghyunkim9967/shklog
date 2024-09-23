package com.shklog.api.service;

import com.shklog.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    public void registerUser(String username, String password, String email) {
//        // 중복 체크
//        if (userRepository.findByUsername(username) != null) {
//            throw new RuntimeException("이미 사용 중인 사용자 이름입니다.");
//        }
//
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode(password)); // 비밀번호 암호화
//        user.setEmail(email);
//
//        userRepository.save(user);
//    }

}
