package toy.project.miniproduct.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import toy.project.miniproduct.dao.ProductOptionDao;
import toy.project.miniproduct.dto.ProductOptionReqDTO;
import toy.project.miniproduct.dto.ProductOptionResDTO;
import toy.project.miniproduct.model.ProductOptionModel;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductOptionService {

    private final ProductOptionDao productOptionDao;

    public int insertProductOption(ProductOptionReqDTO productOptionReqDTO) {
        ProductOptionModel productOptionModel = new ProductOptionModel();
        BeanUtils.copyProperties(productOptionReqDTO, productOptionModel);
        return productOptionDao.insertProductOption(productOptionModel);
    }

    public List<ProductOptionResDTO> selectProductOptions(ProductOptionReqDTO productOptionReqDTO) {
        List<ProductOptionResDTO> result = new ArrayList<>();
        ProductOptionModel productOptionModel = new ProductOptionModel();
        BeanUtils.copyProperties(productOptionReqDTO, productOptionModel);

        List<ProductOptionModel> datas = productOptionDao.selectProductOptions(productOptionModel);
        for (ProductOptionModel item : datas) {
            result.add(new ProductOptionResDTO(item));
        }
        return result;
    }

    public ProductOptionResDTO selectProductOption(ProductOptionReqDTO productOptionReqDTO) {
        ProductOptionModel productOptionModel = new ProductOptionModel();
        BeanUtils.copyProperties(productOptionReqDTO, productOptionModel);
        ProductOptionModel data = productOptionDao.selectProductOption(productOptionModel);
        return new ProductOptionResDTO(data);
    }
    public int updateProductOption(ProductOptionReqDTO productOptionReqDTO) {
        ProductOptionModel productOptionModel = new ProductOptionModel();
        BeanUtils.copyProperties(productOptionReqDTO, productOptionModel);
        return productOptionDao.updateProductOption(productOptionModel);
    }

    public int deleteProductOption(ProductOptionReqDTO productOptionReqDTO) {
        ProductOptionModel productOptionModel = new ProductOptionModel();
        BeanUtils.copyProperties(productOptionReqDTO, productOptionModel);
        return productOptionDao.deleteProductOption(productOptionModel);
    }
}
