package org.wlcn.w5.admin.domain.config;

import com.alibaba.fastjson2.JSONObject;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

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
