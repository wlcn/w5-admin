package org.wlcn.w5.admin.server.infrastructure.config;

import com.mybatisflex.core.audit.AuditManager;
import com.mybatisflex.core.datasource.DataSourceKey;
import com.mybatisflex.core.row.Db;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.wlcn.w5.admin.server.infrastructure.*.mapper")
@Slf4j
public class MyBatisFlexConfiguration implements CommandLineRunner {

    private static final String INIT_SQL = """
            DROP TABLE `t_w5_user` if exists;
            CREATE TABLE IF NOT EXISTS `t_w5_user`
            (
                `id`        INTEGER PRIMARY KEY auto_increment,
                `name`      VARCHAR(100),
                `age`       INTEGER,
                `birthday`  DATETIME
            );
                        
            INSERT INTO t_w5_user(id, name, age, birthday)
            VALUES (1, '张三', 18, '2020-01-11'),
                   (2, '李四', 19, '2021-03-21');
            """;


    public MyBatisFlexConfiguration() {
        //开启审计功能
        AuditManager.setAuditEnable(true);

        //设置 SQL 审计收集器
        AuditManager.setMessageCollector(
                auditMessage ->
                        log.info("{},{} ms", auditMessage.getFullSql(), auditMessage.getElapsedTime())
        );
    }

    @Override
    public void run(String... args) throws Exception {
        Db.tx(() -> {
            try {
                DataSourceKey.use("w5-ds1");
                Db.updateBySql(INIT_SQL);
            } catch (Exception e) {
                log.error("INIT sql error.", e);
            } finally {
                DataSourceKey.clear();
            }
            return Boolean.TRUE;
        });
    }
}
