package com.snqg.chat.domain;

import com.snqg.chat.entity.Message;
import com.snqg.domain.response.chat.MessageVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MsMessageStruct {

    MessageVO msDOToVO(Message message);

    Message msVOToDO(MessageVO messageVO);
}
