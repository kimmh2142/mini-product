package toy.project.miniproduct.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import toy.project.miniproduct.model.ProductModel;

import java.sql.Timestamp;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProductResDTO {
    int productNo;
    String sellerId;
    String productCategory;
    String productName;
    int productPrice;
    int productQuantity;
    int productViewCount;
    Timestamp produceDate;
    String produceId;
    Timestamp modifyDate;
    String modifyId;

    public ProductResDTO(ProductModel item) {
        BeanUtils.copyProperties(item, this);
    }
}
