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

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private UserRepository userRepository;


    /*
    * 게시글 등록
    * function : write(Post)
    * param : Post
    * 게시글 등록 한다.
    * Postman, post.http, 화면(예정)
    * */
    public void write(Post post) {
//        var users = userRepository.findById(userId)
//                .orElseThrow(UserNotFound::new);

//        Post post = Post.builder()
//                .users(users)
//                .title(postCreate.getTitle())
//                .content(postCreate.getContent())
//                .build();

        postRepository.save(post);
    }

    /*
    * 모든 게시글 조회
    * findAllPosts()
    *
    * */
    public List<Post> findAll() {
        // findAll 메소드 기본 제공
        return postRepository.findAll();
    }

    /*
    * 게시글 수정
    * postUpdate
    * */
    public Post postUpdate(Long postId, String title, String content) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Post postUpdate = post.builder()
                .id(post.getId())
                .title(title)
                .content(content)
                .modifiedDate(LocalDateTime.now()) // 수정 날짜 업데이트
                .build();

        return postRepository.save(postUpdate);
    }



}
