package com.snqg.point.domain.dto.product.requst;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class SearchRequest {
    @ApiModelProperty(value = "请求：在积分商城页面之中进行商品的搜索；" +
            "参数功能：搜索的商品是否处于打折状态；" +
            "参数数据类型：整数；" +
            "1)0, 表示只搜索处于打折状态的商品" +
            "2)1, 表示搜索所有状态的商品", example = "1")
    private int isDiscounted;
    @ApiModelProperty(value = "请求：在积分商城页面之中进行商品的搜索；" +
            "参数功能：在数据库之中模糊搜索传入的字符串；" +
            "参数数据类型：字符串", example = "老人与海")
    private String productName;
    @ApiModelProperty(value = "请求：在积分商城页面之中进行商品的搜索；" +
            "参数功能：规定商品类型进行搜索；" +
            "参数数据类型：整数；" +
            "1)1, 食品" +
            "2)2, 书籍" +
            "3)3, 学习用品", example = "2")
    private int category;
}
