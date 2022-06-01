package toy.project.miniproduct.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import toy.project.miniproduct.dao.ProductDao;
import toy.project.miniproduct.dto.ProductReqDTO;
import toy.project.miniproduct.dto.ProductResDTO;
import toy.project.miniproduct.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductDao productDao;

    public int insertProduct(ProductReqDTO productReqDTO) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productReqDTO, productModel);
        return productDao.insertProduct(productModel);
    }

    public List<ProductResDTO> selectProducts(ProductReqDTO productReqDTO) {
        List<ProductResDTO> result = new ArrayList<>();
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productReqDTO, productModel);

        List<ProductModel> datas = productDao.selectProducts(productModel);
        for (ProductModel item : datas) {
            result.add(new ProductResDTO(item));
        }
        return result;
    }

    public ProductResDTO selectProduct(ProductReqDTO productReqDTO) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productReqDTO, productModel);
        ProductModel data = productDao.selectProduct(productModel);
        return new ProductResDTO(data);
    }
    public int updateProduct(ProductReqDTO productReqDTO) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productReqDTO, productModel);
        return productDao.updateProduct(productModel);
    }

    public int deleteProduct(ProductReqDTO productReqDTO) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productReqDTO, productModel);
        return productDao.deleteProduct(productModel);
    }
}
