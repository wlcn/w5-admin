package org.wlcn.w5.admin.application.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.wlcn.w5.admin.domain.user.User;

import java.util.List;

@Mapper
public interface UserInfoConvertMapper {
    UserInfoConvertMapper INSTANCE = Mappers.getMapper(UserInfoConvertMapper.class);

    User userInfoToUser(UserInfo userInfo);

    List<UserInfo> userListToUserInfoList(List<User> userList);

    UserInfo userToUserInfo(User user);

}
