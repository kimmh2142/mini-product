package toy.project.miniproduct.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class BasketModel {
    int basketNo;
    int basketProductOptionNo;
    int productNo;
    String userId;
    int basketProductQuantity;
    Timestamp produceDate;
    String produceId;
    Timestamp modifyDate;
    String modifyId;
}