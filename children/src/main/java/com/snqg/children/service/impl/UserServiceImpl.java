package com.snqg.children.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.snqg.children.constant.RedisPrefix;
import com.snqg.children.domain.MsUserStruct;
import com.snqg.children.entity.User;
import com.snqg.children.service.UserService;
import com.snqg.children.mapper.UserMapper;
import com.snqg.common.exception.ThrowUtil;
import com.snqg.common.util.JwtUtil;
import com.snqg.common.util.StrEncoder;
import com.snqg.common.util.RedisCache;
import com.snqg.common.util.WxUtil;
import com.snqg.context.UserHolder;
import com.snqg.domain.request.children.LoginRequest;
import com.snqg.domain.response.children.LoginResponse;
import com.snqg.domain.response.wx.WxLoginResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


/**
* @author caesar
* @description 针对表【user(用户信息表)】的数据库操作Service实现
* @createDate 2023-11-02 19:10:29
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Resource
    private UserMapper userMapper;

    @Resource
    private WxUtil wxUtil;

    @Resource
    private MsUserStruct userStruct;

    @Resource
    private RedisCache redisCache;

    @Override
    public LoginResponse login(LoginRequest request) {

        WxLoginResponse wxLoginResponse = wxUtil.wxLogin(request.getCode());
        String wxId = wxLoginResponse.getOpenid();
        System.out.println(wxId);
        LoginResponse loginResponse;

        //没有账户，即注册
        if(Objects.isNull(userMapper.selectById(wxId))) {

            String code = request.getInviteCode();

            ThrowUtil.throwIfNull(code, "注册失败，未填写邀请码");

            loginResponse = userStruct.mDOToVO(register(wxId, code));

        }
        //有账户，即登录
        else {
            loginResponse = userStruct.mDOToVO(userMapper.selectUserById(wxId));
        }

        String token = JwtUtil.createJWT(wxId);

        loginResponse.setToken(token);

        redisCache.setCacheObject(RedisPrefix.USER_SESSION_TOKEN + wxId, StrEncoder.encode(token), 1, TimeUnit.DAYS);

        return loginResponse;
    }

    @Override
    public User register(String wxId, String inviteCode) {

        User newUser = userMapper.selectBindInfo(inviteCode);

        ThrowUtil.throwIfNull(newUser, "注册失败：邀请码错误");

        newUser.setId(wxId);
        newUser.setUpdateBy(LocalDateTime.now());
        newUser.setPoint(0);
        newUser.setIsDelete(0);

        userMapper.insert(newUser);

        return newUser;
    }

}