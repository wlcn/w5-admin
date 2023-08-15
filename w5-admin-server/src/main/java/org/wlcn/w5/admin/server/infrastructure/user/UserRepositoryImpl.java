package org.wlcn.w5.admin.server.infrastructure.user;

import com.mybatisflex.annotation.UseDataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.wlcn.w5.admin.server.domain.user.UserModel;
import org.wlcn.w5.admin.server.domain.user.UserRepository;
import org.wlcn.w5.admin.server.infrastructure.user.mapper.UserMapper;

@Repository
@RequiredArgsConstructor
@Slf4j
@UseDataSource("w5-ds1")
public class UserRepositoryImpl implements UserRepository {

    private final UserMapper userMapper;

    @Override
    public UserModel findById(String id) {
        final var userDo = userMapper.selectOneById(id);
        return UserDoMapper.INSTANCE.userDoToUserModel(userDo);
    }
}
