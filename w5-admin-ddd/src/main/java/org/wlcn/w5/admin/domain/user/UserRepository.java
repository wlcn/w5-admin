package org.wlcn.w5.admin.domain.user;

import java.io.Serializable;
import java.util.List;

public interface UserRepository {

    User save(User user);

    User update(User user);

    Integer delete(User user);

    User deleteById(Serializable id);

    User findById(Serializable id);

    List<User> find(User user);

}
