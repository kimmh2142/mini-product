package toy.project.miniproduct.dao;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import toy.project.miniproduct.model.ProductModel;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ProductDao {

    private final SqlSessionTemplate sqlSessionTemplate;

    public int insertProduct(ProductModel model) {
        return sqlSessionTemplate.insert("ProductMapper.insertProduct", model);
    }

    public List<ProductModel> selectProducts(ProductModel model) {
        return sqlSessionTemplate.selectList("ProductMapper.selectProducts", model);
    }

    public int updateProduct(ProductModel model) {
        return sqlSessionTemplate.update("ProductMapper.updateProduct", model);
    }

    public int deleteProduct(ProductModel model) {
        return sqlSessionTemplate.delete("ProductMapper.deleteProduct", model);
    }

    public ProductModel selectProduct(ProductModel model) {
        return sqlSessionTemplate.selectOne("ProductMapper.selectProduct", model);
    }
}
