package org.wlcn.w5.admin.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * profile vo
 */
@Data
@NoArgsConstructor
public class Profile {

    private String name;
    private Integer age;
    private LocalDateTime birthday;

}
