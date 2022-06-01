package toy.project.miniproduct.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import toy.project.miniproduct.model.BasketProductOptionModel;
import toy.project.miniproduct.model.ProductOptionModel;

import java.sql.Timestamp;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class BasketProductOptionResDTO {
    int basketProductOptionNo;
    int sortNo;
    int OptionNo;
    Timestamp produceDate;
    String produceId;
    Timestamp modifyDate;
    String modifyId;

    public BasketProductOptionResDTO(BasketProductOptionModel item) {
        BeanUtils.copyProperties(item, this);
    }
}
