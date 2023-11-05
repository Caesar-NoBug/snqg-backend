package com.snqg.desire.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snqg.desire.entity.Desire;
import com.snqg.desire.service.DesireService;
import com.snqg.desire.mapper.DesireMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86135
* @description 针对表【desire(愿望表)】的数据库操作Service实现
* @createDate 2023-11-04 09:39:54
*/
@Service
public class DesireServiceImpl extends ServiceImpl<DesireMapper, Desire>
    implements DesireService{

    @Override
    public List<Desire> getAllDesire(int id, int childId, String title, String desc) {
        return null;
    }

    @Override
    public String addDesire(int id, String title, String desc) {
        return null;
    }

    @Override
    public int removeDesire(int id) {
        return 0;
    }

    @Override
    public String modifyDesire(int id, String title, String desc, boolean progerss) {
        return null;
    }

    @Override
    public String addThanks(int id, String thanks) {
        return null;
    }

    @Override
    public String modifyThanks(int id, String thanks) {
        return null;
    }

    @Override
    public String getThanks(int id, String thanks){
        return null;
    }
}




