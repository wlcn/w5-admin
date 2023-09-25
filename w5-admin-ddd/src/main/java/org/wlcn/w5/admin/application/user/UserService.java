package org.wlcn.w5.admin.application.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wlcn.w5.admin.domain.user.UserDomainService;

import java.io.Serializable;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserDomainService userDomainService;

    public UserInfo findById(Serializable id) {
        final var user = userDomainService.findById(id);
        log.info("user find by id {}", id);
        return UserInfoConvertMapper.INSTANCE.userToUserInfo(user);
    }
}
