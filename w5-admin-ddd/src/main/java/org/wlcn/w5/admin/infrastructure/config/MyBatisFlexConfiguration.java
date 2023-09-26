package org.wlcn.w5.admin.infrastructure.config;

import cn.hutool.core.io.FileUtil;
import com.mybatisflex.core.audit.AuditManager;
import com.mybatisflex.core.datasource.DataSourceKey;
import com.mybatisflex.core.row.Db;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.wlcn.w5.admin.util.W5Util;

import java.nio.charset.Charset;

@Configuration
@MapperScan("org.wlcn.w5.admin.infrastructure.*.mapper")
@Slf4j
public class MyBatisFlexConfiguration implements CommandLineRunner {

    public MyBatisFlexConfiguration() {
        //开启审计功能
        AuditManager.setAuditEnable(true);

        //设置 SQL 审计收集器
        AuditManager.setMessageCollector(
                auditMessage ->
                        log.info("\nExecute SQL: \n{}\nRunning time: {} ms", auditMessage.getFullSql(), auditMessage.getElapsedTime())
        );
    }

    @Override
    public void run(String... args) throws Exception {
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
