package com.snqg.desire.controller;

import com.snqg.context.UserHolder;
import com.snqg.desire.domain.dto.request.*;
import com.snqg.desire.domain.dto.response.*;
import com.snqg.desire.service.DesireService;
import com.snqg.domain.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

        //从request获取数据
        String childId = UserHolder.getUserId();
        String title = request.getTitle();
        String desc = request.getDesc();

        //添加到数据库
        desireService.addDesire(childId,title,desc);

        AddDesireResponse addDesireResponse = new AddDesireResponse();
        return Response.ok(addDesireResponse);
    }

    @ApiOperation("添加一个感谢")
    @PostMapping("/addThanks")
    public Response<AddThanksResponse> addThanks(@RequestBody AddThanksRequest request){

        //从request里获得需要的数据
        int id = request.getId();
        String thanks = request.getThanks();
        //添加到数据库
       desireService.addThanks(id,thanks);

        AddThanksResponse addThanksResponse = new AddThanksResponse();
      //  String result = desireService.addThanks(id,thanks);
     //   addThanksResponse.setAddThanksResult(result);
        return Response.ok(addThanksResponse);
    }

    @ApiOperation("获取某个儿童所有愿望的详细情况")
    @GetMapping("/getDesire")
    public Response<GetDesireResponse> getDesire(){

        String childId = UserHolder.getUserId();
        GetDesireResponse getDesireResponse = new GetDesireResponse();
        //调用service里的方法，把数据库里查到的信息赋给要返回的getDesrieDreponse
        getDesireResponse.setDesireVoList(desireService.getAllDesire(childId));
        return Response.ok(getDesireResponse);
    }

    @ApiOperation("获取针对某个愿望的感谢")
    @GetMapping("/getThanks/{id}")
    public Response<GetThanksResponse> getThanks(@ApiParam(name = "id", example = "123")
                                                     @PathVariable int id){

        GetThanksResponse getThanksResponse = new GetThanksResponse();
        getThanksResponse.setThanks(desireService.getThanks(id));
        return Response.ok(getThanksResponse);
    }

    @ApiOperation("修改某个愿望的内容")
    @PutMapping("/modifyDesire")
    public Response<ModifyDesireResponse> modifyDesire(@RequestBody ModifyDesireRequest request){

        //获取request中的信息
        int id = request.getId();
        String title = request.getTitle();
        String desc = request.getDesc();
        //修改数据库内容
        String message = desireService.modifyDesire(id,title,desc);
        //给一下提示信息
        ModifyDesireResponse modifyDesireResponse = new ModifyDesireResponse();
        modifyDesireResponse.setMessage(message);
        return Response.ok( modifyDesireResponse);
    }

    @ApiOperation("修改某个感谢的内容")
    @PutMapping("/modifyThanks")
    public Response<ModifyThanksResponse> addThanks(@RequestBody ModifyThanksRequest request){
        //获取requset中信息
        int id = request.getId();
        String thanks = request.getThanks();

        //修改数据库内容
        String message = desireService.modifyThanks(id,thanks);

        //给出提示信息
        ModifyThanksResponse modifyThanksResponse = new ModifyThanksResponse();
        modifyThanksResponse.setMessage(message);
        return Response.ok(modifyThanksResponse);
    }

    @ApiOperation("删除某个愿望")
    @DeleteMapping("/removeDesire")
    public Response<RemoveDesireResponse> removeDesire(@RequestBody RemoveDesireRequest request){

        int id = request.getId();
        desireService.removeDesire(id);

        RemoveDesireResponse removeDesireResponse = new RemoveDesireResponse();
        return Response.ok(removeDesireResponse);
    }

    @ApiOperation("删除感谢")
    @DeleteMapping("/removeThanks")
    public Response<RemoveThanksResponse> removeThanks(@RequestBody RemoveThanksRequset request){

        int id = request.getId();
        desireService.removeThanks(id);

        RemoveThanksResponse removeThanksResponse = new RemoveThanksResponse();
        return Response.ok(removeThanksResponse);
    }

    //6674 6684 6655
}
