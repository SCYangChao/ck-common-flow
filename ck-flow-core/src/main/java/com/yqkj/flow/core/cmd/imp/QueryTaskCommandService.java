package com.yqkj.flow.core.cmd.imp;


import com.yqkj.flow.util.collection.CollectionUtil;
import com.yqkj.flow.constants.FlowConstants;
import com.yqkj.flow.core.cmd.AbstractCommandService;
import com.yqkj.flow.entity.dto.cmd.CommandFlowContext;
import org.flowable.task.api.Task;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
  * class_name: StartCommandService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午6:14
  *
 **/
@Service(FlowConstants.COMMAND_PRE+FlowConstants.FLOW_QUERY_TASK)
public class QueryTaskCommandService extends AbstractCommandService {

    @Override
    public  Boolean excute(CommandFlowContext deployFlowContext){
        List<Task> list = this.iProcessEngine.getTaskService().createTaskQuery().processDefinitionKey(deployFlowContext.getFlowKey()).list();
        deployFlowContext.addResult("taskList", CollectionUtil.convertToList(list , Task::getId));
//        this.iProcessEngine.getRuntimeService().getActiveActivityIds("127")
        return Boolean.TRUE;
    }


}
