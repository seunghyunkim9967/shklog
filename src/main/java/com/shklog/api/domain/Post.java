package com.shklog.api.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class Post {

    /* 게시글 id, title, 작성일, 조회수 
    *  게시글 조회 : 상단 - id, title 중단 - content 하단 - 조회수, 댓글, 작성일시
    * */
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID

    public String title; // 제목

    @Lob
    public String content; // 내용

//    private int hits; // 조회수
//
//    private char deleteYn; // 삭제여부
//
//    private LocalDateTime createdDate = LocalDateTime.now();
//
//    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn
    private Users users;

    @Builder
    public Post(String title, String content, Users users) {
        this.title = title;
        this.content = content;
        this.users = users;
    }
}
