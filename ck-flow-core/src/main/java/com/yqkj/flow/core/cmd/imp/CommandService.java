package com.yqkj.flow.core.cmd.imp;

import com.yqkj.flow.constants.FlowConstants;
import com.yqkj.flow.core.cmd.AbstractCommandService;
import com.yqkj.flow.core.cmd.ICommandService;
import com.yqkj.flow.entity.dto.DeployFlowContext;
import com.yqkj.flow.entity.dto.cmd.CommandFlowContext;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
  * class_name: ICommandService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午9:30
  *
 **/
@Service(value = "commandService")
@Log4j2
public class CommandService implements ICommandService,ApplicationContextAware {
    /**
     * 处理执行流程ServiceService
     */
    private Map<String , ICommandService> deployServiceService = new HashMap<>(10);
    /**
     * @param flowContext
     * @return
     */
    @Override
    public Boolean cmd(CommandFlowContext flowContext) {

        if (log.isDebugEnabled()) {

            log.info("流程发布开始{}" , flowContext);

        }

        String serviceKey = FlowConstants.COMMAND_PRE + flowContext.getCmdEnum().getVlue();
        ICommandService iCommandService = deployServiceService.get(serviceKey);

        if (Objects.isNull(iCommandService)) {

            log.error("iCommandService bean null,command service name:{}", serviceKey);

            flowContext.setSuccess(Boolean.FALSE);

            flowContext.setMsg("流程执行内部出错，流程引擎内部错误");

            return  Boolean.FALSE;

        }

        Boolean deploy = iCommandService.cmd(flowContext);

        if (log.isDebugEnabled()) {

            log.error("flow Command {} result:{}", serviceKey,deploy);

        }

        if (!deploy) {

            flowContext.setSuccess(Boolean.FALSE);
            flowContext.setMsg("流程发布失败");

        }

        return Boolean.TRUE;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        Map<String, AbstractCommandService> beansOfType = applicationContext.getBeansOfType(AbstractCommandService.class);

        if (!Objects.isNull(beansOfType) && !beansOfType.isEmpty()) {

            deployServiceService.putAll(beansOfType);

        }

    }
}
