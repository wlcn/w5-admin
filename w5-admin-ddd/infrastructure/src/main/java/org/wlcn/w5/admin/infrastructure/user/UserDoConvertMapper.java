package org.wlcn.w5.admin.infrastructure.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.wlcn.w5.admin.domain.user.User;

import java.util.List;

@Mapper
public interface UserDoConvertMapper {
    UserDoConvertMapper INSTANCE = Mappers.getMapper(UserDoConvertMapper.class);

    @Mappings({
            @Mapping(source = "profile.name", target = "name"),
            @Mapping(source = "profile.age", target = "age"),
            @Mapping(source = "profile.birthday", target = "birthday")
    })
    UserDo userToUserDo(User user);

    @Mappings({
            @Mapping(source = "name", target = "profile.name"),
            @Mapping(source = "age", target = "profile.age"),
            @Mapping(source = "birthday", target = "profile.birthday")
    })
    User userDoToUser(UserDo userDo);

    List<User> userDoListToUserList(List<UserDo> userDoList);


}
