package org.wlcn.w5.admin.server.application.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserInfo {

    private Integer id;
    private String name;
    private Integer age;
    private LocalDateTime birthday;


}
