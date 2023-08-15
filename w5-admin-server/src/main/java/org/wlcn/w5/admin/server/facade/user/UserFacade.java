package org.wlcn.w5.admin.server.facade.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wlcn.w5.admin.server.api.user.UserResponse;
import org.wlcn.w5.admin.server.application.user.UserService;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserFacade {

    private final UserService userService;

    public UserResponse findById(String id) {
        final var userInfo = userService.findById(id);
        final var userDto = UserDtoMapper.INSTANCE.userInfoToUserDto(userInfo);
        return UserDtoMapper.INSTANCE.userDtoToUserResponse(userDto);
    }
}
