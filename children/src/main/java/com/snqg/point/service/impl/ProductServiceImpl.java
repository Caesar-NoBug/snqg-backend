package com.snqg.point.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snqg.point.domain.MsProductStruct;
import com.snqg.point.domain.vo.ProductVO;
import com.snqg.point.entity.Point;
import com.snqg.point.entity.Product;
import com.snqg.point.mapper.PointMapper;
import com.snqg.point.service.PointService;
import com.snqg.point.service.ProductService;
import com.snqg.point.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
* @author zilu
* @description 针对表【product(商品)】的数据库操作Service实现
* @createDate 2023-11-03 12:02:25
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

    private final PointService pointService;

    @Autowired
    public ProductServiceImpl(PointService pointService) {
        this.pointService = pointService;
    }

    @Resource
    private MsProductStruct msProductStruct;

    @Autowired
    private ProductMapper productMapper;  // 服务层的引用

    @Autowired
    private PointMapper pointMapper;  // 服务层的引用

    /**
     * 查询商品列表
     * @param isDiscount
     * @param productName
     * @param type
     * @return
     */
    @Override
    public List<ProductVO> searchProduct(int isDiscount, String productName, int type) {

        System.out.println("isDiscount = " + isDiscount);
        System.out.println("productName = " + productName);
        System.out.println("type = " + type);
        // 构建查询条件
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        if (isDiscount == 0) {
            queryWrapper.eq("is_discount", 0); // 等于isDiscount的条件
        }

        // 判断category是否为1,2,3
        if (type == 1 || type == 2 || type == 3) {
            queryWrapper.eq("type", type); // 等于type的条件
        }

        if (productName != null) {
            queryWrapper.like("name", productName);
        }

        // 执行查询
        List<Product> productList = productMapper.selectList(queryWrapper);
        System.out.println("productList = " + productList);

        // 将查询结果映射为 ProductVO 对象
        List<ProductVO> productVOList = new ArrayList<>();
        for (Product product : productList) {
            // 这里需要根据你的需求将 Product 映射为 ProductVO
            ProductVO productVO = msProductStruct.toProductVO(product);
            productVOList.add(productVO);
        }

        return productVOList;
    }

    /**
     * 购买商品
     * @param userId
     * @param productId
     * @return
     */
    @Override
    public int purchaseProduct(String userId, int productId) {

        // 根据 productId 查询商品信息
        Product product = productMapper.selectProductById(productId);

        if (product == null) {
            return 1; // 商品不存在
        }

        // 检查商品库存是否充足
        if (product.getCount() <= 0) {
            return 2; // 商品库存不足
        }

        // 检查用户积分是否充足
        int totalPoints = pointService.getTotalPoints(userId, "remaining", "total");
        if (totalPoints < product.getPrice()) {
            return 3; // 积分不足
        }

        // 创建订单
        Point Point = new Point();
        Point.setUserId(userId);
        Point.setChangedPoint(-product.getPrice());
        Point.setChangeTime(LocalDateTime.now());
        Point.setTaskDesc("购买商品：" + product.getName());
        pointMapper.insert(Point);

        // 更新商品库存
        product.setCount(product.getCount() - 1);
        productMapper.updateById(product);

        return 0;
    }
}





