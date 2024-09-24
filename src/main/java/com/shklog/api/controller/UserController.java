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
    private AuthService userService;

    @PostMapping("/join")
    public String join(@RequestBody @Valid Users request) {

        return "user";
    }
}
