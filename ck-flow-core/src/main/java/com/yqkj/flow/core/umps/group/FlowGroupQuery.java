package com.yqkj.flow.core.umps.group;

import lombok.extern.log4j.Log4j2;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.idm.api.Group;
import org.flowable.idm.engine.impl.GroupQueryImpl;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
  * class_name: FlowGroupQuery
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午3:39
  *
 **/
@Log4j2
public class FlowGroupQuery extends GroupQueryImpl {


    @Override
    public List<Group> executeList(CommandContext commandContext) {

        if (log.isInfoEnabled()) {

            log.info("用户列表查询开始：{}", commandContext);

        }

        return super.executeList(commandContext);
    }
}
