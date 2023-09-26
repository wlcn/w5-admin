package org.wlcn.w5.admin.util.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * profile vo
 */
@Data
@Builder
public class Profile {

    private String name;
    private Integer age;
    private LocalDateTime birthday;

}
