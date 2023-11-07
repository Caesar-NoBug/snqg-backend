package com.snqg.point.service;

import com.snqg.point.domain.MsProductStruct;
import com.snqg.point.domain.dto.product.requst.SearchRequest;
import com.snqg.point.domain.dto.product.response.SearchResponse;
import com.snqg.point.domain.vo.ProductVO;
import com.snqg.point.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.annotation.Resource;
import java.util.List;

/**
* @author zilu
* @description 针对表【product(商品)】的数据库操作Service
* @createDate 2023-11-03 12:02:25
*/

public interface ProductService extends IService<Product> {

    /**
     * 查询商品列表
     * @param isDiscount
     * @param productName
     * @param type
     * @return
     */
    List<ProductVO> searchProduct(int isDiscount, String productName, int type);

    /**
     * 购买商品
     * @param userId
     * @param productId
     * @return
     */
    int purchaseProduct(String userId, int productId);
}
