package com.snqg.children.domain;

import com.snqg.children.entity.User;
import com.snqg.domain.response.children.LoginResponse;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MsUserStruct {
    LoginResponse mDOToVO(User user);

    User mVOToDO(LoginResponse loginResponse);
}

