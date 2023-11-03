package com.snqg.point.controller;

import com.snqg.point.domain.vo.ProductVO;
import com.snqg.point.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "积分商城")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService; // 服务层的引用
    @ApiOperation("搜索商品")
    @GetMapping("/search")
    public ResponseEntity<List<ProductVO>> searchProducts(
            @RequestParam(value = "discounted", required = false) int isDiscounted,
            @RequestParam(value = "productName", required = false) String productName,
            @RequestParam(value = "category", required = false) int category
    ) {

//        // 构建查询条件
//        ProductSearchCriteria criteria = new ProductSearchCriteria();
//        criteria.setDiscounted(isDiscounted);
//        criteria.setProductName(productName);
//        criteria.setCategory(category);
//
//        // 调用服务层方法来检索符合条件的产品
//        List<Product> products = productService.searchProducts(criteria);
//
//        return products;

        return null;
    }

    @ApiOperation("购买商品")
    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseProduct(@RequestParam(value = "productId", required = true) String productId) {
//        String userId = UserHolder.getUserId();
        // 在这里执行积分购买商品的逻辑
//        PurchaseResponse response = purchaseService.processPurchase(request);
//        return response;
        return null;
    }
}
