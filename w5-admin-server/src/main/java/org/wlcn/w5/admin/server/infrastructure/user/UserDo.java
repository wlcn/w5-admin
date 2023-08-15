package org.wlcn.w5.admin.server.infrastructure.user;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@Table("t_w5_user")
public class UserDo {

    @Id(keyType = KeyType.Auto)
    private Integer id;
    private String name;
    private Integer age;
    private LocalDateTime birthday;
}
