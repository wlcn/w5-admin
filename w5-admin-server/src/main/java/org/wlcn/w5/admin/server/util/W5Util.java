package org.wlcn.w5.admin.server.util;

import lombok.Getter;

public class W5Util {

    public static final String DATASOURCE_KEY_1 = "w5-ds1";
    public static final String DATASOURCE_KEY_2 = "w5-ds2";

    @Getter
    public enum DataSourceEnum {

        DATASOURCE_1(DATASOURCE_KEY_1),

        DATASOURCE_2(DATASOURCE_KEY_2);

        /**
         * datasource key
         */
        private final String key;

        DataSourceEnum(String key) {
            this.key = key;
        }

    }

}
