package org.wlcn.w5.admin.infrastructure.config;

import com.mybatisflex.core.audit.AuditManager;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.wlcn.w5.admin.infrastructure.*.mapper")
@Slf4j
public class MyBatisFlexConfiguration {

    public MyBatisFlexConfiguration() {
        AuditManager.setAuditEnable(true);

        AuditManager.setMessageCollector(
                auditMessage ->
                        log.info("\nExecute SQL: \n{}\nRunning time: {} ms", auditMessage.getFullSql(), auditMessage.getElapsedTime())
        );
    }

}
