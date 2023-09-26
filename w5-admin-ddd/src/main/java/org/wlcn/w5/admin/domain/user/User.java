package org.wlcn.w5.admin.domain.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class User {

    private String id;

    private String phone;

    private String password;

    private Profile profile;

    @Data
    @Builder
    public static class Profile {

        private String name;
        private Integer age;
        private LocalDateTime birthday;

    }

}
