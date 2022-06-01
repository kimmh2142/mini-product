package toy.project.miniproduct.dao;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import toy.project.miniproduct.model.BasketModel;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BasketDao {

    private final SqlSessionTemplate sqlSessionTemplate;

    public int insertBasket(BasketModel model) {
        return sqlSessionTemplate.insert("BasketMapper.insertBasket", model);
    }

    public List<BasketModel> selectBaskets(BasketModel model) {
        return sqlSessionTemplate.selectList("BasketMapper.selectBaskets", model);
    }

    public int updateBasket(BasketModel model) {
        return sqlSessionTemplate.update("BasketMapper.updateBasket", model);
    }

    public int deleteBasket(BasketModel model) {
        return sqlSessionTemplate.delete("BasketMapper.deleteBasket", model);
    }

    public BasketModel selectBasket(BasketModel model) {
        return sqlSessionTemplate.selectOne("BasketMapper.selectBasket", model);
    }
}
