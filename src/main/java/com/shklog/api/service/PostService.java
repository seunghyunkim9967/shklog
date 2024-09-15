package com.shklog.api.service;

import com.shklog.api.domain.Post;
import com.shklog.api.exception.UserNotFound;
import com.shklog.api.repository.PostRepository;
import com.shklog.api.repository.UserRepository;
import com.shklog.api.request.PostCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final UserRepository userRepository;

    public void write(Long userId, PostCreate postCreate) {
        var users = userRepository.findById(userId)
                .orElseThrow(UserNotFound::new);

        Post post = Post.builder()
                .users(users)
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build();

        postRepository.save(post);
    }

}
