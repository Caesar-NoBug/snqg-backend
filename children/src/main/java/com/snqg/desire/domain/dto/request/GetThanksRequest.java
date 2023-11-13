package com.snqg.desire.domain.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//请求获得针对某个愿望id的感谢
@Data
public class GetThanksRequest {


    @ApiModelProperty(value = "愿望id",example = "1234455")
    private int id;

   // @ApiModelProperty(value = "愿望标题",example = "想要一本词典")
   // private String title;
}
