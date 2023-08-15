package org.wlcn.w5.admin.server.infrastructure.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.wlcn.w5.admin.server.domain.user.UserModel;

@Mapper
public interface UserDoMapper {
    UserDoMapper INSTANCE = Mappers.getMapper(UserDoMapper.class);

    UserModel userDoToUserModel(UserDo userDo);
}
