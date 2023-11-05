package com.snqg.point.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snqg.point.domain.MsProductStruct;
import com.snqg.point.domain.vo.ProductVO;
import com.snqg.point.entity.Point;
import com.snqg.point.entity.Product;
import com.snqg.point.mapper.PointMapper;
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
     * @param category
     * @return
     */
    @Override
    public List<ProductVO> searchProduct(int isDiscount, String productName, int category) {

        // 构建查询条件
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_discount", isDiscount); // 等于isDiscount的条件
        queryWrapper.like(StringUtils.isNotBlank(productName), "product_name", productName); // 模糊匹配productName的条件
        queryWrapper.eq("category", category); // 等于category的条件

        // 执行查询
        List<Product> productList = productMapper.selectList(queryWrapper);

        // 将查询结果映射为 ProductVO 对象
        List<ProductVO> productVOList = new ArrayList<>();
        for (Product product : productList) {
            // 这里需要根据你的需求将 Product 映射为 ProductVO
            ProductVO productVO = msProductStruct.mdoToVO(product);
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
    public String purchaseProduct(String userId, String productId) {

        // 根据 productId 查询商品信息
        Product product = productMapper.selectById(productId);

        if (product == null) {
            return "商品不存在";
        }

        // 检查商品库存是否充足
        if (product.getCount() <= 0) {
            return "商品库存不足";
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

        return "购买成功";
    }
}





