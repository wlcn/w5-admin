package org.wlcn.w5.admin.infrastructure.config;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(W5Properties.class)
@Slf4j
public class W5Configuration {

    @Resource
    private W5Properties properties;

    @Bean
    public void init() {
        log.info("init properties {}", properties);
    }

}
