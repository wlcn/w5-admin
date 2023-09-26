package org.wlcn.w5.admin.adapter.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserQueryRequest {
    private String phone;
}
