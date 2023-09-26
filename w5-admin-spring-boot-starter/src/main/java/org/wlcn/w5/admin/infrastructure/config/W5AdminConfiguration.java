package org.wlcn.w5.admin.infrastructure.config;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class W5AdminConfiguration {

    @Resource
    private W5AdminProperties properties;

    @Bean
    public void init() {
        log.info("init properties {}", properties);

    }

}
