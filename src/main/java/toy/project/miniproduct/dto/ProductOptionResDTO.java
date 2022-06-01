package toy.project.miniproduct.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import toy.project.miniproduct.model.ProductModel;
import toy.project.miniproduct.model.ProductOptionModel;

import java.sql.Timestamp;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProductOptionResDTO {
    int productOptionNo;
    int sortNo;
    int OptionNo;
    int productNo;
    String optionKinds;
    String optionValue;
    Timestamp produceDate;
    String produceId;
    Timestamp modifyDate;
    String modifyId;

    public ProductOptionResDTO(ProductOptionModel item) {
        BeanUtils.copyProperties(item, this);
    }
}
