package com.yqkj.flow.core.umps.user;

import lombok.extern.log4j.Log4j2;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.idm.api.User;
import org.flowable.idm.engine.impl.UserQueryImpl;

import java.util.List;

/**
 *
  * class_name: FlowUserQuery
  * describe: http 用户获取
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午3:24
  *
 **/
@Log4j2
public class FlowUserQuery extends UserQueryImpl {

    @Override
    public List<User> list() {
        return super.list();
    }

    @Override
    public List<User> executeList(CommandContext commandContext) {

        if (log.isInfoEnabled()) {

            log.info("用户列表查询开始：{}", commandContext);

        }
        return super.executeList(commandContext);
    }
}
