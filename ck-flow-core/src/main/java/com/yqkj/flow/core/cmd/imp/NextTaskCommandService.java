package com.yqkj.flow.core.cmd.imp;


import com.yqkj.flow.collection.CollectionUtil;
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
@Service(FlowConstants.COMMAND_PRE+FlowConstants.FLOW_Next_TASK)
public class NextTaskCommandService extends AbstractCommandService {

    @Override
    public  Boolean excute(CommandFlowContext deployFlowContext){
        List<Task> list = this.iProcessEngine.getTaskService().createTaskQuery().processDefinitionKey("xg_ins_depart").list();
        deployFlowContext.addResult("taskList", CollectionUtil.convertToList(list , Task::getProcessInstanceId));
        return Boolean.TRUE;
    }


}
