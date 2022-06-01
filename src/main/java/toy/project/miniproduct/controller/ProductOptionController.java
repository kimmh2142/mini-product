package toy.project.miniproduct.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import toy.project.miniproduct.dto.AjaxResult;
import toy.project.miniproduct.dto.ProductOptionReqDTO;
import toy.project.miniproduct.dto.ProductOptionResDTO;
import toy.project.miniproduct.service.ProductOptionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/product-option")
@RequiredArgsConstructor
@RestController
public class ProductOptionController {

    private final ProductOptionService productOptionService;

    @PostMapping("/create")
    public AjaxResult insertProductOption(@RequestBody ProductOptionReqDTO productOptionReqDTO) {
        int result = productOptionService.insertProductOption(productOptionReqDTO);
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

    @GetMapping("/list")
    public AjaxResult selectProductOptions(ProductOptionReqDTO productOptionReqDTO) {
        List<ProductOptionResDTO> result = productOptionService.selectProductOptions(productOptionReqDTO);
        Map<String, Object> data = new HashMap<>();
        data.put("result", result);
        return AjaxResult.builder().data(data).code(200).isSuccess(true).build();
    }

    @GetMapping("/{productOptionNo}")
    public AjaxResult selectProductOption(@PathVariable("productOptionNo") int productOptionNo, ProductOptionReqDTO productOptionReqDTO) {
        productOptionReqDTO.setProductOptionNo(productOptionNo);
        ProductOptionResDTO result = productOptionService.selectProductOption(productOptionReqDTO);
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

    @PutMapping("/{productOptionNo}")
    public AjaxResult updateProductOption(@PathVariable("productOptionNo") int productOptionNo, @RequestBody ProductOptionReqDTO productOptionReqDTO) {
        productOptionReqDTO.setProductOptionNo(productOptionNo);
        int result = productOptionService.updateProductOption(productOptionReqDTO);
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

    @DeleteMapping("/{productOptionNo}")
    public AjaxResult deleteProductOption(@PathVariable("productOptionNo") int productOptionNo, ProductOptionReqDTO productOptionReqDTO) {
        productOptionReqDTO.setProductOptionNo(productOptionNo);
        int result = productOptionService.deleteProductOption(productOptionReqDTO);
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