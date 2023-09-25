package org.wlcn.w5.admin.domain.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String id;

    private String phone;

    private String password;

    private Profile profile;

    public static class Profile {

        private String name;
        private Integer age;
        private String sex;

    }

}
