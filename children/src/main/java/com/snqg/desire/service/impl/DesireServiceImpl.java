package com.snqg.desire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snqg.desire.domain.MsDesireStruct;
import com.snqg.desire.domain.vo.DesireVo;
import com.snqg.desire.entity.Desire;
import com.snqg.desire.service.DesireService;
import com.snqg.desire.mapper.DesireMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author 86135
* @description 针对表【desire(愿望表)】的数据库操作Service实现
* @createDate 2023-11-04 09:39:54
*/
@Service
public class DesireServiceImpl extends ServiceImpl<DesireMapper, Desire>
    implements DesireService{

    private MsDesireStruct  msDesireStruct;

    private DesireMapper desireMapper;

    //获取某childId下的所有心愿
    @Override
    public List<DesireVo> getAllDesire(String childId) {

        List<Desire> desires = new ArrayList<>();

        QueryWrapper<Desire> queryWrapper= new QueryWrapper<>();

        queryWrapper.eq("id",childId);
        desires = desireMapper.selectList(queryWrapper);

        //判断小孩是否有愿望，没有则返回null
        if(desires.isEmpty()){
            return null;
        }

        List<DesireVo> desireVoList = new ArrayList<>();
        for(Desire desire : desires){
            DesireVo desireVo = new DesireVo();
            desireVo.setId(desire.getId());
            desireVo.setTitle(desire.getTitle());
            desireVo.setDesc(desire.getDesc());
            desireVo.setProgress(desire.getProgress());

            desireVoList.add(desireVo);
        }

        return desireVoList;
    }

    //获取针对某个愿望id的感谢
    @Override
    public String getThanks(int id){

        Desire desire = new Desire();

        QueryWrapper<Desire> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        desire = desireMapper.selectById(queryWrapper);

        String thanks = desire.getThanks();

        return thanks;
    }

    @Override
    //添加一个愿望
    public String addDesire(String childId, String title, String desc) {

        //数据库id自增，不用自己找
        //查找desire库内的最新一个的id，赋值给maxId。这样新id就比之前表最末尾的id大1
      //  QueryWrapper<Desire> queryWrapper = new QueryWrapper<>();
       // queryWrapper.orderByDesc("id").last("LIMIT 1");
      //  Desire maxIdDesire = desireMapper.selectOne(queryWrapper);
      //  int maxId = maxIdDesire != null ? maxIdDesire.getId() : 0;
      //  int newId = maxId+1;

        Desire desire = new Desire();
        //创建新愿望。进度默认未完成，感谢无
      //  desire.setId(newId); 无需设置id
        desire.setChildId(childId);
        desire.setTitle(title);
        desire.setDesc(desc);
        desire.setProgress(0);
        desire.setThanks(null);

        //在数据库内插入新增的desire
        desireMapper.insert(desire);

        return null;
    }

    //添加感谢
    @Override
    public String addThanks(int id, String thanks) {
        //应该查找该id的愿望，然后修改它的thanks，再给它写回数据库
        Desire desire = new Desire();

        QueryWrapper<Desire> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        desire = desireMapper.selectById(queryWrapper);

        // if(desire.getThanks() != ""){
        //     return "已有感谢，无法添加，但可以修改";
        // }
        // else {
        desire.setThanks(thanks);
        desireMapper.updateById(desire);

        return null;
        //  }
    }

    //删除愿望
    @Override
    public String removeDesire(int id) {

        Desire desire = new Desire();

        //查询这个id对应的内容
        QueryWrapper<Desire> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        //删除查询到的结果
        desireMapper.delete(queryWrapper);

        return null;
    }

    //删除感谢
    @Override
    public String removeThanks(int id){

        Desire desire = new Desire();
        //查询这个id对应的内容
        QueryWrapper<Desire> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        desire = desireMapper.selectById(queryWrapper);

        //把其中的感谢改为null=删除感谢
        desire.setThanks(null);

        return null;
    }

    //修改愿望
    @Override
    public String modifyDesire(int id, String title, String desc) {
        Desire desire = new Desire();
        //查询这个id对应的内容
        QueryWrapper<Desire> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        desire = desireMapper.selectById(queryWrapper);
        //按照传进来的参数修改（注意：只有未完成的愿望可以修改。这是合理的)
        if(desire != null){
            if(desire.getProgress() == 0){

                desire.setTitle(title);
                desire.setDesc(desc);
                desire.setProgress(0);
                desire.setThanks(null);

                desireMapper.updateById(desire);
                return "已修改";
            }else {
                return "无法修改已完成的愿望";
            }
        }else {
            return "未找到该愿望";
        }
    }

    //修改感谢
    @Override
    public String modifyThanks(int id, String thanks) {

        Desire desire = new Desire();
        //查询这个id对应的内容
        QueryWrapper<Desire> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        desire = desireMapper.selectById(queryWrapper);

        if(desire != null){
            if(desire.getProgress() != 0){

                desire.setThanks(thanks);
                desireMapper.updateById(desire);
                return "已修改";

            }else {
                return "未完成的愿望无法感谢";
            }
        }else {
            return "未找到该愿望";
        }
    }


}




