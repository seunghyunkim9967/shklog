package com.shklog.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shklog.api.domain.Post;
import com.shklog.api.repository.PostRepository;
import com.shklog.api.repository.UserRepository;
import com.shklog.api.request.PostCreate;
import com.shklog.api.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

//@WebMvcTest
@AutoConfigureMockMvc
@SpringBootTest
class PostControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    //각각의 메서드 실행 전 repository 초기화
    @BeforeEach
    void clean() {
        postRepository.deleteAll();
    }


    @Test
    @DisplayName("/posts 요청시 메시지 정상 출력한다.")
    void test() throws Exception {
        //expected

        mockMvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));

    }

    @Test
    @Disabled
    @DisplayName("글 작성 요청 시 글 저장")
    void test2() throws Exception {
        // given
//        PostCreate request = PostCreate.builder()
//                .title("제목입니다.")
//                .content("내용입니다.")
//                .build();
//
//        String json = objectMapper.writeValueAsString(request);
//        //git
//
//        // when
//        mockMvc.perform(post("/posts")
//                        .header("authorization", "shkman")
//                        .contentType(APPLICATION_JSON)
//                        .content(json))
//                .andExpect(status().isOk())
//                .andDo(print());
//
//        // then
//        assertEquals(1L, postRepository.count());
//
//        Post post = postRepository.findAll().get(0);
//        assertEquals("제목입니다.", post.getTitle());
//        assertEquals("내용입니다.", post.getContent());
    }

    @Test
    @DisplayName("모든 게시글 조회")
    void test3() throws Exception {
        // given
        List<Post> request = Arrays.asList(
                Post.builder()
                .title("테스트 제목입니다.")
                .content("테스트 내용입니다.")
                .build(),
                Post.builder()
                .title("테스트 제목입니다2.")
                .content("테스트 내용입니다2.")
                .build()
        );

        postRepository.saveAll(request);

        //expected
        mockMvc.perform(get("/posts")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].title").value("테스트 제목입니다2."))
                .andExpect(jsonPath("$[1].content").value("테스트 내용입니다2."))
                .andDo(print());

        // then

    }
}