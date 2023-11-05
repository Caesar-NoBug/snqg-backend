package com.snqg.desire.controller;

import com.snqg.desire.domain.dto.request.*;
import com.snqg.desire.domain.dto.response.*;
import com.snqg.desire.service.DesireService;
import com.snqg.domain.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//愿望模块
@RestController
@Api(tags = "愿望")
@RequestMapping("/desire")
public class DesireController {

    @Autowired
    private DesireService desireService;


    @ApiOperation("添加一个愿望")
    @PostMapping("/addDesire")
    public Response<AddDesireResponse> addDesire(@RequestBody AddDesireRequest request){

        AddDesireResponse addDesireResponse = new AddDesireResponse();
        return Response.ok(addDesireResponse);
    }

    @ApiOperation("添加一个感谢")
    @PostMapping("/addThanks")
    public Response<AddThanksResponse> addThanks(@RequestBody AddThanksRequest request){

        AddThanksResponse addThanksResponse = new AddThanksResponse();
        return Response.ok(addThanksResponse);
    }

    @ApiOperation("获取某个儿童所有愿望的详细情况")
    @GetMapping("/getDesire")
    public Response<GetDesireResponse> getDesire(@RequestBody GetDesireRequest request){

        GetDesireResponse getDesireResponse = new GetDesireResponse();
        return Response.ok(getDesireResponse);
    }

    @ApiOperation("获取针对某个愿望的感谢")
    @GetMapping("/getThanks")
    public Response<GetThanksResponse> getThanks(@RequestBody GetThanksRequest request){

        GetThanksResponse getThanksResponse = new GetThanksResponse();
        return Response.ok(getThanksResponse);
    }

    @ApiOperation("修改某个愿望的内容")
    @PutMapping("/modifyDesire")
    public Response<ModifyDesireResponse> modifyDesire(@RequestBody ModifyDesireRequest request){

        ModifyDesireResponse modifyDesireResponse = new ModifyDesireResponse();
        return Response.ok( modifyDesireResponse);
    }

    @ApiOperation("修改某个感谢的内容")
    @PutMapping("/modifyThanks")
    public Response<ModifyThanksResponse> addThanks(@RequestBody ModifyThanksRequest request){

        ModifyThanksResponse modifyThanksResponse = new ModifyThanksResponse();
        return Response.ok(modifyThanksResponse);
    }

    @ApiOperation("删除某个愿望")
    @DeleteMapping("/removeDesire")
    public Response<RemoveDesireResponse> removeDesire(@RequestBody RemoveDesireRequest request){
        RemoveDesireResponse removeDesireResponse = new RemoveDesireResponse();
        return Response.ok(removeDesireResponse);
    }

    @ApiOperation("删除感谢")
    @DeleteMapping("/removeThanks")
    public Response<RemoveThanksResponse> removeThanks(@RequestBody RemoveThanksRequset request){
        RemoveThanksResponse removeThanksResponse = new RemoveThanksResponse();
        return Response.ok(removeThanksResponse);
    }

}
