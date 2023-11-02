package com.snqg.children.controller;

import com.snqg.domain.request.wx.WxLoginRequest;
import com.snqg.domain.response.Response;
import com.snqg.domain.response.children.ChildrenVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

//个人信息模块
@RestController
@Api(tags = "个人信息")
@RequestMapping("/children")
public class ChildrenController {

    @ApiOperation("儿童端登录")
    @PostMapping("/login")
    public Response<ChildrenVO> login(@RequestBody WxLoginRequest request) {
        ChildrenVO childrenVO = new ChildrenVO();
        childrenVO.setAvatar("");
        return Response.ok(childrenVO);
    }

}
