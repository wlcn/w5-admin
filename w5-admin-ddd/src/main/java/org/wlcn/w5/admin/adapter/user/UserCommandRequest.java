package org.wlcn.w5.admin.adapter.user;

import lombok.Builder;
import lombok.Data;
import org.wlcn.w5.admin.domain.user.User;

import java.time.LocalDateTime;

@Data
@Builder
public class UserCommandRequest {

    private String id;

    private String phone;

    private String password;

    private User.Profile profile;

    public static class Profile {

        private String name;
        private Integer age;
        private LocalDateTime birthday;

    }
}
