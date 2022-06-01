package toy.project.miniproduct.dao;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import toy.project.miniproduct.model.ProductOptionModel;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ProductOptionDao {

    private final SqlSessionTemplate sqlSessionTemplate;

    public int insertProductOption(ProductOptionModel model) {
        return sqlSessionTemplate.insert("ProductOptionMapper.insertProductOption", model);
    }

    public List<ProductOptionModel> selectProductOptions(ProductOptionModel model) {
        return sqlSessionTemplate.selectList("ProductOptionMapper.selectProductOptions", model);
    }

    public int updateProductOption(ProductOptionModel model) {
        return sqlSessionTemplate.update("ProductOptionMapper.updateProductOption", model);
    }

    public int deleteProductOption(ProductOptionModel model) {
        return sqlSessionTemplate.delete("ProductOptionMapper.deleteProductOption", model);
    }

    public ProductOptionModel selectProductOption(ProductOptionModel model) {
        return sqlSessionTemplate.selectOne("ProductOptionMapper.selectProductOption", model);
    }
}
