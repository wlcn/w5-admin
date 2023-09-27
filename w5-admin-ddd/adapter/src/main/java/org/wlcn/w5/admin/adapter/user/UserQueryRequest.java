package org.wlcn.w5.admin.adapter.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.wlcn.w5.admin.vo.Profile;

@Data
@Builder
@Jacksonized
public class UserQueryRequest {

    @NotBlank
    private String phone;

    private Profile profile;
}
