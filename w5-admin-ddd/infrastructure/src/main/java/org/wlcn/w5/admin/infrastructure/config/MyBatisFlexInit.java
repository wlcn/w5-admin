package org.wlcn.w5.admin.infrastructure.config;

import cn.hutool.core.io.FileUtil;
import com.mybatisflex.core.datasource.DataSourceKey;
import com.mybatisflex.core.row.Db;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.wlcn.w5.admin.util.W5Util;

import java.nio.charset.Charset;

@Component
@Profile("local")
@Slf4j
public class MyBatisFlexInit {

    @PostConstruct
    public void init() {
        Db.tx(() -> {
            try {
                final var dmlSql = FileUtil.readString("db/h2-schema.sql", Charset.defaultCharset());
                final var ddlSql = FileUtil.readString("db/h2-data.sql", Charset.defaultCharset());
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
