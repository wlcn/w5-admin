package org.wlcn.w5.admin.adapter.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.wlcn.w5.admin.application.user.UserInfo;

import java.util.List;

@Mapper
public interface UserConvertMapper {
    UserConvertMapper INSTANCE = Mappers.getMapper(UserConvertMapper.class);

    UserResponse userInfoToUserResponse(UserInfo userInfo);

    List<UserResponse> userInfoListToUserResponseList(List<UserInfo> userInfoList);

    UserInfo userCommandRequestToUserInfo(UserCommandRequest userCommandRequest);

}
