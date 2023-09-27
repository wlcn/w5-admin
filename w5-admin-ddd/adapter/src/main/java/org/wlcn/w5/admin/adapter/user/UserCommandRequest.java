package org.wlcn.w5.admin.adapter.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.wlcn.w5.admin.vo.Profile;

@Data
@Builder
public class UserCommandRequest {

    @NotBlank(groups = UpdateGroup.class)
    private String id;

    @NotBlank(groups = {SaveGroup.class, UpdateGroup.class})
    private String phone;

    @NotBlank(groups = {SaveGroup.class, UpdateGroup.class})
    private String password;

    private Profile profile;

    public interface SaveGroup {
    }

    public interface UpdateGroup {
    }

}
