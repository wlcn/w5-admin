package org.wlcn.w5.admin.server.facade.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.wlcn.w5.admin.server.api.user.UserResponse;
import org.wlcn.w5.admin.server.application.user.UserInfo;

@Mapper
public interface UserDtoMapper {

    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    UserDto userInfoToUserDto(UserInfo userInfo);


    UserInfo userDtoToUserInfo(UserDto userDto);

    UserResponse userDtoToUserResponse(UserDto userDto);
}
