package com.snqg.desire.service;

import com.snqg.desire.domain.vo.DesireVo;
import com.snqg.desire.entity.Desire;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 86135
* @description 针对表【desire(愿望表)】的数据库操作Service
* @createDate 2023-11-04 09:39:54
*/
public interface DesireService extends IService<Desire> {

    //获取某个儿童的所有愿望
    List<DesireVo> getAllDesire(String childId );

    //增加愿望
    String addDesire(String childId , String title ,String detail);

    //删除（未完成的）愿望
    String removeDesire(int id );

    //修改（未完成的）愿望
    String modifyDesire(int id , String title , String detail );

    //给已完成的愿望发布感谢
    String addThanks(int id , String thanks);

    //修改感谢内容
    String modifyThanks( int id , String thanks);

    //获取感谢内容
    String getThanks(int id );

    String removeThanks(int id);

}
