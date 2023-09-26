package org.wlcn.w5.admin.infrastructure.config;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Builder
@ConfigurationProperties(prefix = "w5")
public class W5Properties {

    private Admin admin;

    @Data
    @Builder
    public static class Admin {
        private String name;

        private String password;
    }
}
