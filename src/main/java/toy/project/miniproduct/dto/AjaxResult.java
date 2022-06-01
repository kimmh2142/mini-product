package toy.project.miniproduct.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AjaxResult {
    int code;
    boolean isSuccess;
    Map<String, Object> data;
}
