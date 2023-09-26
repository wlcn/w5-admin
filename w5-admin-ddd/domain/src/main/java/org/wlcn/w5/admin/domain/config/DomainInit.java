package org.wlcn.w5.admin.domain.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
@Slf4j
public class DomainInit {

    @Value("${domain.name}")
    private String name;

    @PostConstruct
    public void init() {
        log.info("{} is ready.", name);
    }

}
