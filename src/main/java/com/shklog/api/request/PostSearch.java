package com.shklog.api.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PostSearch {

    private static final int MAX_SIZE = 2000; // 최대 사이즈

    @Builder.Default
    private Integer page = 1; // Default Page 번호

    @Builder.Default
    private Integer size = 30; // Page 사이즈

    @Builder
    public PostSearch(Integer page, Integer size) {
        this.page = page == null ? 1 : page;
        this.size = size == null ? 30 : size;
    }



}
