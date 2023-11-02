package com.snqg.children.mapper;

import com.snqg.children.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;

/**
* @author caesar
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-11-01 23:06:27
* @Entity com.snqg.children.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




