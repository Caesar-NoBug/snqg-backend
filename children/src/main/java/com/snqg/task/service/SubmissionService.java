package com.snqg.task.service;

import com.snqg.task.entity.Submission;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ldj123456789
* @description 针对表【submission(任务提交结果表)】的数据库操作Service
* @createDate 2023-11-04 22:35:14
*/
public interface SubmissionService extends IService<Submission> {
//    1.任务求助模块：输入初步定为小孩ID、任务求助内容；；输出初步定为志愿者ID

    boolean seekHelpTask(String childId, String content);
}
