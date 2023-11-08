package com.snqg.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snqg.point.domain.vo.PointVO;
import com.snqg.point.entity.Point;
import com.snqg.task.entity.Submission;
import com.snqg.task.service.SubmissionService;
import com.snqg.task.mapper.SubmissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author ldj123456789
* @description 针对表【submission(任务提交结果表)】的数据库操作Service实现
* @createDate 2023-11-04 22:35:14
*/
@Service
public class SubmissionServiceImpl extends ServiceImpl<SubmissionMapper, Submission>
    implements SubmissionService{

    @Autowired
    private SubmissionMapper submissionMapper;
//    儿童寻找帮助，返回聊天界面？还是提示发送成功？
    @Override
    public boolean seekHelpTask(int childId, String content) {
//        通过小孩id查询志愿者id，将求助内容发送给志愿者
        List<Submission> submissions = new ArrayList<>();

//        从数据库里查到对应的小孩
        Submission submission = new Submission();
        submission.setChildId(String.valueOf(childId));
        QueryWrapper<Submission> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("child_id",childId);
        submissions = submissionMapper.selectList(queryWrapper);

//        判断是否有这个小孩
        if(submissions.isEmpty()) {
            return false;
        }
        else {
//            设置该小孩的数值
            for (Submission submission1 : submissions) {
                submission.setId(submission1.getId());
                submission.setTaskId(submission1.getTaskId());
                submission.setContent(content);
                submission.setSubmitTime(submission1.getSubmitTime());
            }
        }

//        更新小孩的数值
        submissionMapper.updateById(submission);

        return true;
    }
}




