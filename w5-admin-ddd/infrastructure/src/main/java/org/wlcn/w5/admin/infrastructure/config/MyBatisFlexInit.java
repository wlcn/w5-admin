package org.wlcn.w5.admin.infrastructure.config;

import cn.hutool.core.io.FileUtil;
import com.mybatisflex.core.datasource.DataSourceKey;
import com.mybatisflex.core.row.Db;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.wlcn.w5.admin.util.W5Util;

@Component
@Profile("local")
@Slf4j
public class MyBatisFlexInit {

    @PostConstruct
    public void init() {
        Db.tx(() -> {
            try {
                final var dmlSql = FileUtil.readUtf8String("classpath:db/h2-schema.sql");
                final var ddlSql = FileUtil.readUtf8String("classpath:db/h2-data.sql");
                DataSourceKey.use(W5Util.DataSourceEnum.DATASOURCE_1.getKey());
                Db.updateBySql(dmlSql);
                Db.updateBySql(ddlSql);
            } catch (Exception e) {
                log.error("INIT sql error.", e);
            } finally {
                DataSourceKey.clear();
            }
            return Boolean.TRUE;
        });
    }

}
