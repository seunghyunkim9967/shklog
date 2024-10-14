package com.shklog.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSearch {

    @NotBlank(message = "이메일을 입력해주십쇼...")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주십쇼...")
    private String password;

}
