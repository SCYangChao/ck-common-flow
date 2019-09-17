package com.yqkj.flow.core.cmd.imp;


import com.yqkj.flow.constants.FlowConstants;
import com.yqkj.flow.core.cmd.AbstractCommandService;
import com.yqkj.flow.entity.dto.cmd.CommandFlowContext;
import org.springframework.stereotype.Service;

/**
 *
  * class_name: StartCommandService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午6:14
  *
 **/
@Service(FlowConstants.COMMAND_PRE+FlowConstants.FLOW_END_TASK)
public class EndTaskCommandService extends AbstractCommandService<Boolean> {

    @Override
    public  Boolean excute(CommandFlowContext<Boolean> deployFlowContext){
        this.iProcessEngine.getRuntimeService().deleteProcessInstance("","");
        this.iProcessEngine.getTaskService().complete("", null);
        deployFlowContext.addResult(this.RESULT_FLAG, Boolean.TRUE);
        return Boolean.TRUE;
    }


}
