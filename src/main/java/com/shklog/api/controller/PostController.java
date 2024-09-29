package com.shklog.api.controller;

import com.shklog.api.domain.Post;
import com.shklog.api.request.PostCreate;
import com.shklog.api.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public void post(@RequestBody @Valid Post request) {

//        return "";
        postService.write(request);
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> postUpdate(@PathVariable Long id, @RequestBody Post updatedPost) {
        Post post = postService.postUpdate(id, updatedPost.getTitle(), updatedPost.getContent());
        return ResponseEntity.ok(post);
    }

}
