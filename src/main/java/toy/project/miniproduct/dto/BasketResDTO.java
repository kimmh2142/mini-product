package toy.project.miniproduct.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import toy.project.miniproduct.model.BasketModel;
import toy.project.miniproduct.model.ProductModel;

import java.sql.Timestamp;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class BasketResDTO {
    int basketNo;
    int basketProductOptionNo;
    int productNo;
    String userId;
    int basketProductQuantity;
    Timestamp produceDate;
    String produceId;
    Timestamp modifyDate;
    String modifyId;

    public BasketResDTO(BasketModel item) {
        BeanUtils.copyProperties(item, this);
    }
}
