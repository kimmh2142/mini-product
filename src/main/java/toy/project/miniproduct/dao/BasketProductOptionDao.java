package toy.project.miniproduct.dao;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import toy.project.miniproduct.model.BasketProductOptionModel;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BasketProductOptionDao {

    private final SqlSessionTemplate sqlSessionTemplate;

    public int insertBasketProductOption(BasketProductOptionModel model) {
        return sqlSessionTemplate.insert("BasketProductOptionMapper.insertBasketProductOption", model);
    }

    public List<BasketProductOptionModel> selectBasketProductOptions(BasketProductOptionModel model) {
        return sqlSessionTemplate.selectList("BasketProductOptionMapper.selectBasketProductOptions", model);
    }

    public int updateBasketProductOption(BasketProductOptionModel model) {
        return sqlSessionTemplate.update("BasketProductOptionMapper.updateBasketProductOption", model);
    }

    public int deleteBasketProductOption(BasketProductOptionModel model) {
        return sqlSessionTemplate.delete("BasketProductOptionMapper.deleteBasketProductOption", model);
    }

    public BasketProductOptionModel selectBasketProductOption(BasketProductOptionModel model) {
        return sqlSessionTemplate.selectOne("BasketProductOptionMapper.selectBasketProductOption", model);
    }
}
