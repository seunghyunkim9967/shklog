package com.shklog.api.controller;

import com.shklog.api.domain.Users;
import com.shklog.api.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public Users signup(@RequestBody @Valid Users request) {
        try {
            return authService.signup(request);
        } catch (Exception e) {
            // 에러 응답 처리 (단순 에러 메시지 전송)
            throw new RuntimeException(e.getMessage());
        }
    }
}
