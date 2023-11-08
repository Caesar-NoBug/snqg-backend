package com.snqg.point.domain;

import com.snqg.point.domain.vo.ProductVO;
import com.snqg.point.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MsProductStruct {

    //这里需要对象的对应属性名称相同
    ProductVO toProductVO(Product product);
}
