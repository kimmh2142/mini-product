package toy.project.miniproduct.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import toy.project.miniproduct.dto.UserGetResDTO;
import toy.project.miniproduct.service.UserService;

import java.util.List;

@RequestMapping("/user")
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    // Model, DTO, VO
    // SI - 빨리끝내야되니까
    @ResponseBody
    @GetMapping("/")
    public List<UserGetResDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/test1")
    public String test1() {
        return "test1";
    }
}





// 사용자가 요청하는 데이터 - Req DTO - 사용자가 요청하는 데이터를 갖고있는 객체 - Client(?) Layer
// 사용자에게 보여줄 데이터 - Res DTO - 사용자에게 보여줄 데이터만 가공해서 갖고있는 객체 - Service Layer
// DB 에서 가져오는 데이터 - 모델 (쿼리상에서는 조인해서도 가져오니까 해당 데이터만 갖고있는 객체) - DAO Layer
// DB 테이블 과 완벽하게 1:1 매핑되는걸 - VO (테이블의 개념을 설명할 수 있는거고) - DB Layer ㅎ

// JPA 장점 - Model안써도됨

// Controller - 사용자의 요청을 받는 창구
// Service - 사용자의 요청을 처리하는 함수를 담고있는 인터페이스
// ServiceImpl - Service의 구현체 (함수의 상세로직을 담고있는 클래스)
// DAO - DB Layer로 접근해서 뭔갈 하기 위한 행위를 담고있는 객체
// SqlSessionTemplate - 특정 사용자의 DB 세션을 갖고있는 객체 (mybatis 쪽 내장된 클래스) - DB Session Pool -> 세션을 관리하는 장소
// (10명이 DB이용중이면, 그게 만약 maximum이면, 11번째 유저는 기다려야함)

// mybatis (SqlSessionTemplate, dao) vs jpa (Repository, JpaBuilder)

// getMyInfo(세션);