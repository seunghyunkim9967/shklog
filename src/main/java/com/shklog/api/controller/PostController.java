package com.shklog.api.controller;

import com.shklog.api.domain.Post;
import com.shklog.api.request.PostCreate;
import com.shklog.api.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private PostService postService;

    @GetMapping("/posts")
    public void post(@RequestBody @Valid PostCreate request) {

//        return "";
        postService.write(1L,request);
    }

}
