package toy.project.miniproduct.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class UserGetResDTO {
    String name;
    String phone;
}
