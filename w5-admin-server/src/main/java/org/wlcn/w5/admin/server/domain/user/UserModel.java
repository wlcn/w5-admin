package org.wlcn.w5.admin.server.domain.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserModel {

    private Integer id;
    private String name;
    private Integer age;
    private LocalDateTime birthday;


}
