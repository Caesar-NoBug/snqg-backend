package com.snqg.children.controller;

import com.snqg.children.service.UserService;
import com.snqg.context.UserHolder;
import com.snqg.domain.request.children.LoginRequest;
import com.snqg.domain.response.Response;
import com.snqg.domain.response.children.LoginResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//个人信息模块
@RestController
@Api(tags = "个人信息")
@RequestMapping("/children")
public class ChildrenController {

    @Resource
    private UserService userService;

    @ApiOperation("儿童端登录")
    @PostMapping("/login")
    public Response<LoginResponse> login(@RequestBody LoginRequest request) {
        return Response.ok(userService.login(request));
    }

    @ApiOperation("测试接口：测试token是否可用")
    @GetMapping("/test-token")
    public Response<String> testToken() {
        return Response.ok("token可用,当前用户id为：" + UserHolder.getUserId());
    }

}
