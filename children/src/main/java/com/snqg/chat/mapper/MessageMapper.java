package com.snqg.chat.mapper;

import com.snqg.chat.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snqg.domain.response.chat.MessageVO;

import java.time.LocalDateTime;
import java.util.List;

/**
* @author caesar
* @description 针对表【message(消息表)】的数据库操作Mapper
* @createDate 2023-11-03 14:08:40
* @Entity com.snqg.chat.entity.Message
*/
public interface MessageMapper extends BaseMapper<Message> {

    List<Message> pullMessage(String userId, LocalDateTime startTime);

    int sendMessage(Message message);

    int isFriend(String userAId, String userBId);

}




