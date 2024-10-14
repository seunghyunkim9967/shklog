package com.shklog.api.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreate {

    @Email(message = "유효한 이메일을 입력하세요.")
    @NotBlank(message = "이름을 입력해주십쇼...")
    private String name;
    
    @NotBlank(message = "이메일을 입력해주십쇼...")
    private String email;
    
    @NotBlank(message = "비밀번호를 입력해주십쇼...")
    private String password;

    @Builder
    public UserCreate(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
