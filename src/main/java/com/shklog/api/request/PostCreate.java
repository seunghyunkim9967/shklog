package com.shklog.api.request;

import com.shklog.api.domain.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class PostCreate {
    @NotBlank(message = "타이틀을 입력해주십쇼...")
    public String title;
//    @NotBlank(message = "내용을 입력해주십쇼...")
    public String content;

    public Post post;

    public PostCreate() {

    }

    @Builder
    public PostCreate(String title, String content) {
        // Post Entity
        this.title = title;
        this.content = content;
    }

//    @Builder
//    public PostCreate(Post post) {
//        // Post Entity
//        this.title = post.getTitle();
//        this.content = post.getContent();
//    }

//    public Post fdfd(){
////        return Post
//    }

//    public void validate() {
//        if (title.contains("null title")) {
//            throw new InvalidRequest("title", "타이틀 = null title입니다.");
//        }
//    }
}
