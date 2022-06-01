package toy.project.miniproduct.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProductModel {
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
}