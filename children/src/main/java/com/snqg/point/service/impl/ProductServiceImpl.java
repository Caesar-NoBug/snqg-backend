package com.snqg.point.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snqg.point.entity.Product;
import com.snqg.point.service.ProductService;
import com.snqg.point.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author zilu
* @description 针对表【product(商品)】的数据库操作Service实现
* @createDate 2023-11-03 12:02:25
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




