package com.snqg.task.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snqg.task.entity.Submission;
import com.snqg.task.service.SubmissionService;
import com.snqg.task.mapper.SubmissionMapper;
import org.springframework.stereotype.Service;

/**
* @author ldj123456789
* @description 针对表【submission(任务提交结果表)】的数据库操作Service实现
* @createDate 2023-11-04 22:35:14
*/
@Service
public class SubmissionServiceImpl extends ServiceImpl<SubmissionMapper, Submission>
    implements SubmissionService{

    @Override
    public int seekHelpTask(int childId, String content) {
        return 0;
    }
}




