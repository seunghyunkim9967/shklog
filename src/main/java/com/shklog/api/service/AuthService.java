package com.shklog.api.service;

import com.shklog.api.domain.Users;
import com.shklog.api.repository.UserRepository;
import com.shklog.api.request.UserCreate;
import com.shklog.api.request.UserSearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    //패스워드 인코더 사용
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /* 회원가입
    *  builder 변경
    * */
    public void signup(UserCreate userCreate) throws Exception {

        // 이메일 중복 확인
        if (userRepository.findByEmail(userCreate.getEmail()).isPresent()) {
            throw new RuntimeException("이미 사용 중인 이메일입니다.");
        }

        try {
            Users user = Users.builder()
                    .name(userCreate.getName())
                    .email(userCreate.getEmail())
                    .password(passwordEncoder.encode(userCreate.getPassword()))
                    .build();
            userRepository.save(user);
        } catch (Exception e) {
            log.error("회원가입 중 오류 발생: ", e);
            throw e; // 예외를 다시 던져서 컨트롤러에서 처리하도록 함
        }
    }

    /* 로그인 */
    public void login(UserSearch userSearch) {
        try {
            log.info("authService 실행 : ");
            // 사용자 정보를 데이터베이스에서 조회
            Users user = userRepository.findByEmail(userSearch.getEmail())
                    .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
            log.info("email : " + userSearch.getEmail());
            // 입력된 비밀번호와 저장된 인코딩된 비밀번호 비교
            boolean isPasswordMatch = passwordEncoder.matches(userSearch.getPassword(), user.getPassword());
            log.info("Match : " + isPasswordMatch);
            if (!isPasswordMatch) {
                throw new RuntimeException("비밀번호가 일치하지 않습니다.");
            }
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            userSearch.getEmail(),
//                            userSearch.getPassword()
//                    )
//            );
            log.info("authService 종료 : ");
        } catch (AuthenticationException e) {
            throw new RuntimeException("로그인 실패: " + e.getMessage());
        }
    }

}
