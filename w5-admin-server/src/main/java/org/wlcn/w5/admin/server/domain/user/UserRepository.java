package org.wlcn.w5.admin.server.domain.user;

public interface UserRepository {

    UserModel findById(String id);
}
