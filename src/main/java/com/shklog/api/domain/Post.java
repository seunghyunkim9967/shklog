package com.shklog.api.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

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
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn
    private Users users;

    @Builder
    public Post(Long id,String title, String content, Users users, LocalDateTime modifiedDate) {
        //게시글 수정 시 ID를 명시적으로 포함 (테스트)
        this.id = id;
        this.title = title;
        this.content = content;
        this.users = users;
        this.modifiedDate = modifiedDate;
    }
}
