package toy.project.miniproduct.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProductOptionModel {
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
}