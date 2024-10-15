package com.shklog.api.controller;

import com.shklog.api.domain.Users;
import com.shklog.api.request.UserCreate;
import com.shklog.api.request.UserSearch;
import com.shklog.api.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid UserCreate userCreate, BindingResult result) {
        if (result.hasErrors()) {
            log.info(String.valueOf(ResponseEntity.badRequest().body(result.getAllErrors())));
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        try {
            authService.signup(userCreate);
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            // 에러 응답 처리 (단순 에러 메시지 전송)
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody @Valid UserSearch userSearch, BindingResult result) {
        if (result.hasErrors()) {
            log.error("로그인 요청 오류: {}", result.getAllErrors());
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        try {
            // 로그 찍기
            log.info("Received signin request: email={}, password={}", userSearch.getEmail(), userSearch.getPassword());
            authService.login(userSearch);
            return ResponseEntity.ok().build(); // 200 OK
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request
        }
    }
}
