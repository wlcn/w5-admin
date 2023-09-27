package org.wlcn.w5.admin.infrastructure.user;

import com.mybatisflex.core.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.wlcn.w5.admin.domain.user.User;
import org.wlcn.w5.admin.domain.user.UserRepository;
import org.wlcn.w5.admin.infrastructure.user.mapper.UserDoMapper;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository {

    private final UserDoMapper userDoMapper;

    @Override
    public User save(User user) {
        final var userDo = UserDoConvertMapper.INSTANCE.userToUserDo(user);
        final var effectCounts = userDoMapper.insert(userDo);
        log.info("save user, effect counts {}", effectCounts);
        return findById(userDo.getId());
    }

    @Override
    public User update(User user) {
        final var existUser = findById(user.getId());
        Objects.requireNonNull(existUser, "user must exist when update.");
        final var userDo = UserDoConvertMapper.INSTANCE.userToUserDo(user);
        final var effectCounts = userDoMapper.update(userDo);
        log.info("update user, effect counts {}", effectCounts);
        return findById(userDo.getId());
    }

    @Override
    public Integer delete(User user) {
        final var userDo = UserDoConvertMapper.INSTANCE.userToUserDo(user);
        final var queryWrapper = QueryWrapper.create(userDo);
        final var effectCounts = userDoMapper.deleteByQuery(queryWrapper);
        log.info("delete user, effect counts {}", effectCounts);
        return effectCounts;
    }

    @Override
    public User deleteById(Serializable id) {
        final var existUser = userDoMapper.selectOneById(id);
        Objects.requireNonNull(existUser, "user must exist when delete.");
        userDoMapper.deleteById(id);
        return UserDoConvertMapper.INSTANCE.userDoToUser(existUser);
    }

    @Override
    public User findById(Serializable id) {
        final var userDo = userDoMapper.selectOneById(id);
        return UserDoConvertMapper.INSTANCE.userDoToUser(userDo);
    }

    @Override
    public List<User> find(User user) {
        final var userDo = UserDoConvertMapper.INSTANCE.userToUserDo(user);
        final var queryWrapper = QueryWrapper.create(userDo);
        final var userDoList = userDoMapper.selectListByQuery(queryWrapper);
        log.info("find user, user list size {}", userDoList.size());
        return UserDoConvertMapper.INSTANCE.userDoListToUserList(userDoList);
    }
}
