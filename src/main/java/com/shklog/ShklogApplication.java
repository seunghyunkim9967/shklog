package com.shklog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShklogApplication {
    public static void main(String[] args) {
        /*
        *  코드 정리 관련
        *  1. 일관된 코드 스타일 유지 ( 변수, 함수, 들여쓰기 등 )
        *  2. 모듈화 ( 기능별로 코드를 모듈화, 가독성 높임, 각 모듈당 하나의 기능을 책임져야 함 )
        *  3. 정렬된 파일 및 폴더 구조 조직
        *  4. 명확하고 직관적인 네이밍을 사용하여 그 기능을 유추 가능하도록 명시
        *  5. 코드 중복 최소화 ( 같은 행동을 3번 이상 반복하는 경우 의심해볼 필요 있음 )
        * */

        /*
        *  주석 작성 요령
        *  1. 명확한 설명 ( 함수나 메서드의 목적, 파라미터, 반환 값 등 주석으로 명확하게 설명 코멘트 )
        *  2. 복잡한 로직이 있는 경우 설명 기술하여 다른 개발자가 이해할 수 있도록 작성
        *  3. TODO, FIXME 주석 ( 코드에서 개선 필요한 부분이나 버그를 주석으로 남겨 후속 작업 기억하도록 작성 )
        *  4. 주석의 필요성 판단 ( 코드가 명확한 경우 주석을 줄이고 필요한 경우 간결하게 작성, 코드 자체로 설명이 되면 베스트 )
        *  5. 주석 업데이트 ( 작성한 주석은 최신 상태를 유지해야 함 )
        * */

        /*
        * 가독성을 위한 포인트
        * 1. 코드 리뷰와 피드백
        * 2. 테스트 작성
        * 3. 사용자 입장에서 예외 처리를 고려
        * 4. API 문서화
        * 5. 자주 사용하는 패턴과 원칙 이해
        * 6. 성능 고려
        * */
        
        //implementation 'org.springframework.boot:spring-boot-starter-security' security 의존성 추가 시 보안 설정으로 인해 로그인 페이지가 보여짐 
        SpringApplication.run(ShklogApplication.class, args);
    }
}
