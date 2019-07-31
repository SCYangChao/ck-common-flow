package com.yqkj.flow.core.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
  * class_name: MysqlProcessEngineConfiguration
  * describe: Mysql数据库初始化
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午5:10
  *
 **/
@Configuration
@ConditionalOnProperty(prefix = "flow.mysql",name = {"open"}, havingValue = "true")
@ConfigurationProperties(prefix = "flow.mysql")
@Data
public class MysqlProcessEngineConfiguration {
    /**
     * 数据库链接
      */
    private String jdbcUrl;
    /**
     * 数据名称
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * JDBC数据驱动
     */
    private String JdbcDriver;

}
