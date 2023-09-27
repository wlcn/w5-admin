package org.wlcn.w5.admin.adapter.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserQueryRequest {

    @NotBlank
    private String phone;
}
