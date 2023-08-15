package org.wlcn.w5.admin.server.application.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wlcn.w5.admin.server.domain.user.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserInfo findById(String id) {
        final var userModel = userRepository.findById(id);
        return UserInfoMapper.INSTANCE.userModelToUserInfo(userModel);
    }
}
