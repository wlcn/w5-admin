package org.wlcn.w5.admin.server.application.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.wlcn.w5.admin.server.domain.user.UserModel;

@Mapper
public interface UserInfoMapper {

    UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);

    UserModel userInfoToUserModel(UserInfo userInfo);

    UserInfo userModelToUserInfo(UserModel userModel);
}
