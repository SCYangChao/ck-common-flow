package com.yqkj.flow.config;

import com.yqkj.flow.core.umps.group.FlowGroupQuery;
import com.yqkj.flow.core.umps.user.FlowUserQuery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
  * class_name: HttpIdmIdentityService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午3:41
  *
 **/
@Configuration
public class FlowIdentityService {
    /**
     * 用户查询管理
     * @return
     */
    @Bean
    public FlowUserQuery initHttpUserQuery(){
        return  new FlowUserQuery();
    }

    /**
     * 用户组查询管理
     * @return
     */
    @Bean
    public FlowGroupQuery initHttpGroupQuery(){
        return  new FlowGroupQuery();
    }
}