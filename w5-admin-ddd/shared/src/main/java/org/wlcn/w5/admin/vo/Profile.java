package org.wlcn.w5.admin.vo;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

/**
 * profile vo
 */
@Data
@Builder
@Jacksonized
public class Profile {

    private String name;
    private Integer age;
    private LocalDateTime birthday;

}
