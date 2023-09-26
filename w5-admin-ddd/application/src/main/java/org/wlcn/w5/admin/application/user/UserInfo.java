package org.wlcn.w5.admin.application.user;

import lombok.Builder;
import lombok.Data;
import org.wlcn.w5.admin.vo.Profile;

@Data
@Builder
public class UserInfo {

    private String id;

    private String phone;

    private String password;

    private Profile profile;


}
