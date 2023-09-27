package org.wlcn.w5.admin.adapter.user;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.wlcn.w5.admin.vo.Profile;

@Data
@Builder
@Jacksonized
public class UserResponse {

    private String id;

    private String phone;

    private String password;

    private Profile profile;


}
