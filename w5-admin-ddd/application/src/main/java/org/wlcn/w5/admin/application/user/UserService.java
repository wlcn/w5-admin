package org.wlcn.w5.admin.application.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wlcn.w5.admin.domain.user.UserDomainService;

import java.io.Serializable;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserDomainService userDomainService;

    public UserInfo save(UserInfo userInfo) {
        final var user = UserInfoConvertMapper.INSTANCE.userInfoToUser(userInfo);
        final var savedUser = userDomainService.save(user);
        return UserInfoConvertMapper.INSTANCE.userToUserInfo(savedUser);
    }

    public UserInfo update(UserInfo userInfo) {
        final var user = UserInfoConvertMapper.INSTANCE.userInfoToUser(userInfo);
        final var updatedUser = userDomainService.update(user);
        return UserInfoConvertMapper.INSTANCE.userToUserInfo(updatedUser);
    }

    public Integer delete(UserInfo userInfo) {
        final var user = UserInfoConvertMapper.INSTANCE.userInfoToUser(userInfo);
        final var deleted = userDomainService.delete(user);
        log.info("deleted records {}", deleted);
        return deleted;
    }

    public UserInfo deleteById(Serializable id) {
        final var deletedUser = userDomainService.deleteById(id);
        return UserInfoConvertMapper.INSTANCE.userToUserInfo(deletedUser);
    }

    public UserInfo findById(Serializable id) {
        final var user = userDomainService.findById(id);
        log.info("user find by id {}", id);
        return UserInfoConvertMapper.INSTANCE.userToUserInfo(user);
    }

    public List<UserInfo> find(UserInfo userInfo) {
        final var user = UserInfoConvertMapper.INSTANCE.userInfoToUser(userInfo);
        final var foundRecordList = userDomainService.find(user);
        return UserInfoConvertMapper.INSTANCE.userListToUserInfoList(foundRecordList);
    }
}
