package org.wlcn.w5.admin.infrastructure.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.wlcn.w5.admin.domain.user.User;

import java.util.List;

@Mapper
public interface UserDoConvertMapper {
    UserDoConvertMapper INSTANCE = Mappers.getMapper(UserDoConvertMapper.class);

    User userDoToUser(UserDo userDo);

    List<User> userDoListToUserList(List<UserDo> userDoList);

    UserDo userToUserDo(User user);

}
