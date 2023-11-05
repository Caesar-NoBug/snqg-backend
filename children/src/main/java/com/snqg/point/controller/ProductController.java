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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    public Response<SearchResponse> searchProducts(
            @RequestBody SearchRequest searchRequest) {

        List<ProductVO> productList = productService.searchProduct(
                searchRequest.getIsDiscounted(),
                searchRequest.getProductName(),
                searchRequest.getCategory());

        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setProductVOList(productList);
        return Response.ok(searchResponse);
    }

    @ApiOperation("购买商品")
    @PostMapping("/purchase")
    public Response<PurchaseResponse> purchaseProduct(
            @RequestBody PurchaseRequest purchaseRequest) {

        String userId = UserHolder.getUserId();
        // 在这里执行积分购买商品的逻辑
        String productId = purchaseRequest.getProductId();
        String purchaseResult = productService.purchaseProduct(userId, productId);

        PurchaseResponse purchaseResponse = new PurchaseResponse();
        purchaseResponse.setPurchaseResult(purchaseResult);

        return Response.ok(purchaseResponse);
    }
}
