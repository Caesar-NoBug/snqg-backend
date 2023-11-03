package com.snqg.children.service;

import com.snqg.children.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.snqg.domain.request.children.LoginRequest;
import com.snqg.domain.response.children.LoginResponse;

/**
* @author caesar
* @description 针对表【user(用户信息表)】的数据库操作Service
* @createDate 2023-11-02 19:10:29
*/
public interface UserService extends IService<User> {

    LoginResponse login(LoginRequest request);

    User register(String wxId, String inviteCode);

}
