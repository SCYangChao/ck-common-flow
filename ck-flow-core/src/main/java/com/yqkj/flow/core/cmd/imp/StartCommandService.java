package com.yqkj.flow.core.cmd.imp;


import com.yqkj.flow.constants.FlowConstants;
import com.yqkj.flow.core.cmd.AbstractCommandService;
import com.yqkj.flow.entity.dto.cmd.CommandFlowContext;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

/**
 *
  * class_name: StartCommandService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午6:14
  *
 **/
@Service(FlowConstants.COMMAND_PRE+FlowConstants.FLOW_START)
public class StartCommandService extends AbstractCommandService {

    @Override
    public  Boolean excute(CommandFlowContext deployFlowContext){
        ProcessInstance processInstance = this.iProcessEngine.getRuntimeService().startProcessInstanceByKey(deployFlowContext.getFlowKey()
                , deployFlowContext.getVariable());
        return Boolean.TRUE;
    }


}
