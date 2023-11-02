package com.snqg.children.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snqg.children.entity.User;
import com.snqg.children.service.UserService;
import com.snqg.children.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author caesar
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-11-01 23:06:27
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private UserMapper userMapper;

}




