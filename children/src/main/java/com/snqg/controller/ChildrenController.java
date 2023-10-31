package com.snqg.controller;

import com.snqg.domain.request.children.WxLoginRequest;
import com.snqg.domain.response.Response;
import com.snqg.domain.response.children.ChildrenVO;
import com.snqg.domain.response.volunteer.UserMinVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "children")
@RequestMapping("/children")
public class ChildrenController {

    @ApiOperation("儿童端登录")
    @PostMapping("/login")
    public Response<UserMinVO> login(@RequestBody WxLoginRequest request) {
        UserMinVO userMinVO = new UserMinVO();
        userMinVO.setId(12334L);
        userMinVO.setType(0);
        userMinVO.setAvatar("");
        return Response.ok(userMinVO);
    }

}
