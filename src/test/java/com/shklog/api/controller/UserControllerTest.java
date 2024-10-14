package com.shklog.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shklog.api.repository.PostRepository;
import com.shklog.api.repository.UserRepository;
import com.shklog.api.request.UserCreate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    //각각의 메서드 실행 전 repository 초기화
    @BeforeEach
    void clean() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("회원가입 정상 작동 확인")
    public void testSignup() throws Exception {
        // 1. 회원가입 요청
        UserCreate request = UserCreate.builder()
                .name("testName")
                .email("testUser")
                .password("testPassword")
                .build();

        String json = objectMapper.writeValueAsString(request);
        //git

        // when
        mockMvc.perform(post("/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated()) // 성공 시 201
                .andDo(print());
    }

    @Test
    @DisplayName("로그인 정상 작동 확인")
    public void testLogin() throws Exception {
        // 1. 회원가입 요청
        UserCreate request = UserCreate.builder()
        .name("testName")
        .email("testUser")
        .password("testPassword")
        .build();

        String json = objectMapper.writeValueAsString(request);

        // when
        // 1. 회원가입
        mockMvc.perform(post("/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andDo(print());

        // 2. 로그인 요청
        mockMvc.perform(post("/signin")
                        .param("name", "testName")
                        .param("email", "testUser")
                        .param("password", "testPassword"))
                .andExpect(status().isOk())
                .andDo(print()); // 성공 응답 확인 200
    }
}