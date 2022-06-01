package toy.project.miniproduct.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class BasketProductOptionModel {
    int basketProductOptionNo;
    int sortNo;
    int OptionNo;
    Timestamp produceDate;
    String produceId;
    Timestamp modifyDate;
    String modifyId;
}