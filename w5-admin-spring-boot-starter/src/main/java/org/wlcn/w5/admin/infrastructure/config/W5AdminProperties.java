package org.wlcn.w5.admin.infrastructure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "w5.admin")
public class W5AdminProperties {

    private String name;

    private String password;
}
