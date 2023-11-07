package com.snqg.point.controller;

import com.snqg.context.UserHolder;
import com.snqg.domain.response.Response;
import com.snqg.point.domain.dto.product.requst.PurchaseRequest;
import com.snqg.point.domain.dto.product.requst.SearchRequest;
import com.snqg.point.domain.dto.product.response.PurchaseResponse;
import com.snqg.point.domain.dto.product.response.SearchResponse;
import com.snqg.point.domain.vo.ProductVO;
import com.snqg.point.entity.Product;
import com.snqg.point.service.ProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "积分商城")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService; // 服务层的引用
    @ApiOperation("搜索商品")
    @GetMapping("/search")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "isDiscounted", value = "请求：在积分商城页面之中进行商品的搜索；" +
                    "参数功能：搜索的商品是否处于打折状态；" +
                    "参数数据类型：整数；" +
                    "1)0, 表示只搜索处于打折状态的商品；" +
                    "2)1, 表示搜索所有状态的商品；", example = "1", required = true),
            @ApiImplicitParam(name = "productName", value = "请求：在积分商城页面之中进行商品的搜索；" +
                    "参数功能：在数据库之中模糊搜索传入的字符串；" +
                    "参数数据类型：字符串；" +
                    "补充说明：实际上是一个可选的参数，如果选择不传入此参数则会将所有商品都搜索出来", example = "老人与海"),
            @ApiImplicitParam(name = "type", value = "请求：在积分商城页面之中进行商品的搜索；" +
                    "参数功能：规定商品类型进行搜索；" +
                    "参数数据类型：整数；" +
                    "1)1, 代表检索食品；" +
                    "2)2, 代表检索书籍；" +
                    "3)3, 代表检索学习用品；" +
                    "4)其他，表示检索范围不限；", example = "2", required = true)
    })
    public Response<SearchResponse> searchProducts(
            @RequestParam int isDiscounted,
            @RequestParam(required = false) String productName,
            @RequestParam int type) {

        List<ProductVO> productList = productService.searchProduct(
                isDiscounted, productName, type);

        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setProductVOList(productList);
        return Response.ok(searchResponse);
    }

    @ApiOperation("购买商品")
    @PostMapping("/purchase")
    public Response<PurchaseResponse> purchaseProduct(
            @RequestBody PurchaseRequest purchaseRequest) {

        System.out.println("purchaseRequest = " + purchaseRequest);

        String userId = UserHolder.getUserId();
        // 在这里执行积分购买商品的逻辑
        int productId = purchaseRequest.getProductId();
        int purchaseResult = productService.purchaseProduct(userId, productId);

        PurchaseResponse purchaseResponse = new PurchaseResponse();

        if (purchaseResult == 0) {
            purchaseResponse.setPurchaseResult("购买成功");
            return Response.ok(purchaseResponse);
        } else if (purchaseResult == 1) {
            return Response.error("积分不足");
        } else if (purchaseResult == 2) {
            return Response.error("商品不存在");
        } else {
            return Response.error("未知错误");
        }
    }
}
