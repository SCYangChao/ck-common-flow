package com.yqkj.flow.core.cmd.imp;


import com.yqkj.flow.constants.FlowConstants;
import com.yqkj.flow.core.cmd.AbstractCommandService;
import com.yqkj.flow.entity.dto.cmd.CommandFlowContext;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 *
  * class_name: StartCommandService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午6:14
  *
 **/
@Service(FlowConstants.COMMAND_PRE+FlowConstants.FLOW_START)
public class StartCommandService extends AbstractCommandService<Map<String, String>> {

    @Override
    public  Boolean excute(CommandFlowContext<Map<String, String>> deployFlowContext){
        ProcessInstance processInstance = this.iProcessEngine.getRuntimeService().startProcessInstanceByKey(deployFlowContext.getFlowKey()
                , deployFlowContext.getVariable());
        String processInstanceId = processInstance.getProcessInstanceId();
//        this.iProcessEngine.getTaskService().getVariables()
        Map<String , String>  result = new HashMap<>();
        result.put("processInstanceId" , processInstanceId);
        result.put("processDefinitionId" , processInstance.getProcessDefinitionId());
        deployFlowContext.addResult(this.RESULT_FLAG,result);
        return Boolean.TRUE;
    }


}
