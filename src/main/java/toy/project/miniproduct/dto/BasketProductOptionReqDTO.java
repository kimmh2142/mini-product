package toy.project.miniproduct.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class BasketProductOptionReqDTO {
    int basketProductOptionNo;
    int sortNo;
    int OptionNo;
    Timestamp produceDate;
    String produceId;
    Timestamp modifyDate;
    String modifyId;
}
