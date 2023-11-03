package com.snqg.children.mapper;

import com.snqg.children.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author caesar
* @description 针对表【user(用户信息表)】的数据库操作Mapper
* @createDate 2023-11-02 19:10:29
* @Entity com.snqg.children.entity.User
*/
public interface UserMapper extends BaseMapper<User> {

    User selectUserById(String id);

    User selectBindInfo(String inviteCode);

    int removeBindInfo(String inviteCode);

    int addBindInfo(String inviteCode, User user);
}




