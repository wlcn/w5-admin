package org.wlcn.w5.admin.domain.user;

import lombok.Builder;
import lombok.Data;
import org.wlcn.w5.admin.util.vo.Profile;


@Data
@Builder
public class User {

    private String id;

    private String phone;

    private String password;

    private Profile profile;


}
