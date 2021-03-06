package toy.project.miniproduct.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import toy.project.miniproduct.dto.AjaxResult;
import toy.project.miniproduct.dto.BasketReqDTO;
import toy.project.miniproduct.dto.BasketResDTO;
import toy.project.miniproduct.service.BasketService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/basket")
@RequiredArgsConstructor
@RestController
public class BasketController {

    private final BasketService basketService;

    @PostMapping("/create")
    public AjaxResult insertBasket(@RequestBody BasketReqDTO basketReqDTO) {
        int result = basketService.insertBasket(basketReqDTO);
        Map<String, Object> data = new HashMap<>();
        data.put("result",result);
        AjaxResult ajaxResult;
        if (result > 0 ){
            ajaxResult = AjaxResult.builder().data(data).code(200).isSuccess(true).build();
        } else {
            ajaxResult = AjaxResult.builder().data(data).code(999).isSuccess(false).build();
        }
        return ajaxResult;
    }

    /**유저 장바구니 리스트*/
    @GetMapping("/list/{userId}")
    public AjaxResult selectBaskets(@PathVariable("userId") String userId, BasketReqDTO basketReqDTO) {
        basketReqDTO.setUserId(userId);
        List<BasketResDTO> result = basketService.selectBaskets(basketReqDTO);
        Map<String, Object> data = new HashMap<>();
        data.put("result", result);
        return AjaxResult.builder().data(data).code(200).isSuccess(true).build();
    }

    /**장바구니 상세(필요할까?)*/
    @GetMapping("/{basketNo}")
    public AjaxResult selectBasket(@PathVariable("basketNo") int basketNo, BasketReqDTO basketReqDTO) {
        basketReqDTO.setBasketNo(basketNo);
        BasketResDTO result = basketService.selectBasket(basketReqDTO);
        Map<String, Object> data = new HashMap<>();
        data.put("result", result);
        AjaxResult ajaxResult;
        if (result != null) {
            ajaxResult = AjaxResult.builder().data(data).code(200).isSuccess(true).build();
        } else {
            ajaxResult = AjaxResult.builder().data(data).code(999).isSuccess(false).build();
        }
        return ajaxResult;
    }

    @PutMapping("/{basketNo}")
    public AjaxResult updateBasket(@PathVariable("basketNo") int basketNo, @RequestBody BasketReqDTO basketReqDTO) {
        basketReqDTO.setBasketNo(basketNo);
        int result = basketService.updateBasket(basketReqDTO);
        Map<String, Object> data = new HashMap<>();
        data.put("result", result);
        AjaxResult ajaxResult;
        if (result > 0) {
            ajaxResult = AjaxResult.builder().data(data).code(200).isSuccess(true).build();
        } else {
            ajaxResult = AjaxResult.builder().data(data).code(999).isSuccess(false).build();
        }
        return ajaxResult;
    }

    @DeleteMapping("/{basketNo}")
    public AjaxResult deleteBasket(@PathVariable("basketNo") int basketNo, BasketReqDTO basketReqDTO) {
        basketReqDTO.setBasketNo(basketNo);
        int result = basketService.deleteBasket(basketReqDTO);
        Map<String, Object> data = new HashMap<>();
        data.put("result", result);
        AjaxResult ajaxResult;
        if (result > 0) {
            ajaxResult = AjaxResult.builder().data(data).code(200).isSuccess(true).build();
        } else {
            ajaxResult = AjaxResult.builder().data(data).code(999).isSuccess(false).build();
        }
        return ajaxResult;
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