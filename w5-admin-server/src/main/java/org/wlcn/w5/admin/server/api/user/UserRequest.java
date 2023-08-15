package org.wlcn.w5.admin.server.api.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserRequest {

    private Integer id;
    private String name;
    private Integer age;
    private LocalDateTime birthday;
}
