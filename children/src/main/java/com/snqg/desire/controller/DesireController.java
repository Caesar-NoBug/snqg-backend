package com.snqg.desire.controller;

import com.snqg.desire.domain.dto.request.*;
import com.snqg.desire.domain.dto.response.*;
import com.snqg.desire.service.DesireService;
import com.snqg.domain.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//愿望模块
@RestController
@Api(tags = "愿望")
@RequestMapping("/desire")
public class DesireController {

    @Autowired
    private DesireService desireService;


    @ApiOperation("添加一个愿望")
    @GetMapping("/addDesire")
    public Response<AddDesireResponse> addDesire(@RequestBody AddDesireRequest request){

        AddDesireResponse addDesireResponse = new AddDesireResponse();
        return Response.ok(addDesireResponse);
    }

    @ApiOperation("添加一个感谢")
    @GetMapping("/addThanks")
    public Response<AddThanksResponse> addThanks(@RequestBody AddThanksRequest request){

        AddThanksResponse addThanksResponse = new AddThanksResponse();
        return Response.ok(addThanksResponse);
    }

    @ApiOperation("获取某个儿童所有愿望的详细情况")
    @GetMapping("/allDesire")
    public Response<AllDesireResponse> allDesire(@RequestBody AllDesireRequest request){

        AllDesireResponse allDesireResponse = new AllDesireResponse();
        return Response.ok(allDesireResponse);
    }

    @ApiOperation("获取针对某个愿望的感谢")
    @GetMapping("/getThanks")
    public Response<GetThanksResponse> addDesire(@RequestBody GetThanksRequest request){

        GetThanksResponse getThanksResponse = new GetThanksResponse();
        return Response.ok(getThanksResponse);
    }

    @ApiOperation("修改某个愿望的内容")
    @GetMapping("/modifyDesire")
    public Response<ModifyDesireResponse> addDesire(@RequestBody ModifyDesireRequest request){

        ModifyDesireResponse modifyDesireResponse = new ModifyDesireResponse();
        return Response.ok( modifyDesireResponse);
    }

    @ApiOperation("修改某个感谢的内容")
    @GetMapping("/modifyThanks")
    public Response<ModifyThanksResponse> addDesire(@RequestBody ModifyThanksRequest request){

        ModifyThanksResponse modifyThanksResponse = new ModifyThanksResponse();
        return Response.ok(modifyThanksResponse);
    }

    @ApiOperation("删除某个愿望")
    @GetMapping("/removeDesire")
    public Response<RemoveDesireResponse> addDesire(@RequestBody RemoveDesireRequest request){
        RemoveDesireResponse removeDesireResponse = new RemoveDesireResponse();
        return Response.ok(removeDesireResponse);
    }

    @ApiOperation("删除感谢")
    @GetMapping("/removeThanks")
    public Response<RemoveThanksResponse> addDesire(@RequestBody RemoveThanksRequset request){
        RemoveThanksResponse removeThanksResponse = new RemoveThanksResponse();
        return Response.ok(removeThanksResponse);
    }

}
